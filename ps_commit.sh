#!/usr/bin/env bash
set -euo pipefail

# === 설정(필요시 수정) ====================================
STATUS_TAG="[AC]"          # 기본 상태 태그 (예: [AC], [WA], [AGAIN])
USE_FULL_YEAR=false        # true면 YYYYMMDD, false면 YYMMDD
PUSH_AFTER_COMMIT=false    # 커밋 후 자동 푸시 기본값
# ==========================================================

usage() {
  cat <<'EOF'
사용법: ./ps_commit.sh [옵션] <문제번호...>

옵션:
  -s, --status <태그>   상태 태그 설정 (기본: 설정값)
      --again           상태 태그를 [AGAIN] 으로 설정
      --full-year       날짜를 YYYYMMDD 형식으로 사용
      --push            커밋 후 현재 브랜치로 push
      --no-push         push 하지 않음 (기본값과 동일)
      --changed         변경된 문제 파일 자동 수집(번호 인자 불필요)
  -h, --help            도움말

예시:
  ./ps_commit.sh 2438 2562 2309
  ./ps_commit.sh 1475 -s "[WA]"
  ./ps_commit.sh 2438 2562 --full-year
  ./ps_commit.sh --changed --again --push
EOF
}

# 기본값
status="$STATUS_TAG"
use_full_year="$USE_FULL_YEAR"
push_after="$PUSH_AFTER_COMMIT"
use_changed=false

# 유틸: 문제파일 여부 판단
is_problem_file() {
  local p="$1"
  [[ "$p" =~ ^src/.*/_[0-9]{3,5}(_again)?\.java$ ]]
}

# 유틸: 파일명에서 문제번호 추출 ("_1406_again.java" -> 1406)
extract_num_from_filename() {
  local fname="$1" rest
  fname="${fname#_}"           # 앞의 '_'
  rest="${fname%%.*}"           # 확장자 제거
  echo "${rest%%_*}"             # _again 등 제거
}

# 옵션 파싱
args=()
while [[ $# -gt 0 ]]; do
  case "$1" in
    -h|--help) usage; exit 0;;
    -s|--status) status="${2:-$STATUS_TAG}"; shift 2;;
    --again) status="[AGAIN]"; shift;;
    --full-year) use_full_year=true; shift;;
    --push) push_after=true; shift;;
    --no-push) push_after=false; shift;;
    --changed) use_changed=true; shift;;
    -*) echo "알 수 없는 옵션: $1"; usage; exit 1;;
    *) args+=("$1"); shift;;
  esac
done

# 날짜/요일
if $use_full_year; then
  DATE=$(date +"%Y%m%d")
else
  DATE=$(date +"%y%m%d")
fi
DOW=$(date +"%a")

# 문제번호/경로 수집
problem_nums=()
paths_to_add=()

if $use_changed; then
  # 변경된 파일에서 문제파일만 선별
  while IFS= read -r -d '' entry; do
    # entry 예: "MM src/barkingDog/x04/_1406_again.java"
    local_path="${entry:3}"
    is_problem_file "$local_path" || continue
    fname=$(basename "$local_path")
    num=$(extract_num_from_filename "$fname")
    [[ -n "$num" ]] && problem_nums+=("$num") && paths_to_add+=("$local_path")
  done < <(git status --porcelain=v1 -z)

  if [[ ${#problem_nums[@]} -eq 0 ]]; then
    echo "오류: 변경된 문제 파일을 찾지 못했습니다."
    exit 1
  fi
else
  # 인자로 받은 문제번호 사용
  if [[ ${#args[@]} -eq 0 ]]; then
    echo "오류: 최소 1개 이상의 문제번호가 필요합니다. (또는 --changed 사용)"
    usage; exit 1
  fi

  # 숫자만 추출하여 배열에 적재
  for p in "${args[@]}"; do
    num="${p//[^0-9]/}"
    [[ -n "$num" ]] && problem_nums+=("$num")
  done
  if [[ ${#problem_nums[@]} -eq 0 ]]; then
    echo "오류: 유효한 문제번호가 없습니다."; exit 1
  fi

  # 워킹트리에서 해당 번호의 문제파일 경로 수집
  while IFS= read -r -d '' p; do
    is_problem_file "$p" || continue
    fname=$(basename "$p")
    num=$(extract_num_from_filename "$fname")
    # membership 체크
    for want in "${problem_nums[@]}"; do
      if [[ "$want" == "$num" ]]; then
        paths_to_add+=("$p")
        break
      fi
    done
  done < <(git ls-files -co --exclude-standard -z -- src)

  if [[ ${#paths_to_add[@]} -eq 0 ]]; then
    echo "오류: 지정한 번호에 해당하는 문제 파일을 찾지 못했습니다."
    exit 1
  fi
fi

# 번호 정리(중복 제거 + 정렬)
problem_nums_sorted=()
while IFS= read -r n; do
  [[ -n "$n" ]] && problem_nums_sorted+=("$n")
done < <(printf '%s\n' "${problem_nums[@]}" | sed '/^$/d' | sort -n | uniq)

# 커밋 메시지 조립: "2444[AC], 2445[AC]"
problems_joined=""
for num in "${problem_nums_sorted[@]}"; do
  if [[ -z "$problems_joined" ]]; then
    problems_joined="${num}${status}"
  else
    problems_joined="${problems_joined}, ${num}${status}"
  fi
done

if [[ -z "$problems_joined" ]]; then
  echo "오류: 커밋 메시지 구성에 실패했습니다."
  exit 1
fi

commit_msg="${DATE}(${DOW}): ${problems_joined}"

# Git 작업: 선택된 문제 파일만 스테이징하여 일관성 유지
git restore --staged :/ 2>/dev/null || true
git add -- "${paths_to_add[@]}"
git commit -m "$commit_msg"

if $push_after; then
  current_branch=$(git rev-parse --abbrev-ref HEAD)
  git push origin "$current_branch"
fi

echo "✅ 커밋 완료: $commit_msg"
$push_after && echo "⬆️  push 완료"

