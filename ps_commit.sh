#!/usr/bin/env bash
set -euo pipefail

# === 설정(필요시 수정) ====================================
STATUS_TAG="[AC]"          # 기본 상태 태그
USE_FULL_YEAR=false        # true면 YYYYMMDD, false면 YYMMDD
PUSH_AFTER_COMMIT=true     # 커밋 후 자동 푸시
# ==========================================================

usage() {
  cat <<'EOF'
사용법: ./ps_commit.sh <문제번호...> [-s 상태태그] [--full-year] [--no-push]

예시:
  ./ps_commit.sh 2438 2562 2309
  ./ps_commit.sh 1475 -s "[WA]"         # 상태 태그 변경
  ./ps_commit.sh 2438 2562 --full-year  # 20250909 형식 날짜
EOF
}

# 기본값
status="$STATUS_TAG"
use_full_year="$USE_FULL_YEAR"
push_after="$PUSH_AFTER_COMMIT"

# 옵션 파싱
args=()
while [[ $# -gt 0 ]]; do
  case "$1" in
    -h|--help) usage; exit 0;;
    -s|--status) status="${2:-$STATUS_TAG}"; shift 2;;
    --full-year) use_full_year=true; shift;;
    --no-push) push_after=false; shift;;
    -*)
      echo "알 수 없는 옵션: $1"; usage; exit 1;;
    *)
      args+=("$1"); shift;;
  esac
done

if [[ ${#args[@]} -eq 0 ]]; then
  echo "오류: 최소 1개 이상의 문제번호가 필요합니다."
  usage; exit 1
fi

# 날짜/요일
if $use_full_year; then
  DATE=$(date +"%Y%m%d")   # 예: 20250909
else
  DATE=$(date +"%y%m%d")   # 예: 250909
fi
DOW=$(date +"%a")          # Mon/Tue/Wed...

# 문제번호 포맷팅: "2444[AC], 2445[AC], ..."
problems_joined=""
for p in "${args[@]}"; do
  num="${p//[^0-9]/}"
  [[ -z "$num" ]] && continue
  if [[ -z "$problems_joined" ]]; then
    problems_joined="${num}${status}"
  else
    problems_joined="${problems_joined}, ${num}${status}"
  fi
done

if [[ -z "$problems_joined" ]]; then
  echo "오류: 유효한 문제번호가 없습니다."; exit 1
fi

# 커밋 메시지
commit_msg="${DATE}(${DOW}): ${problems_joined}"

# Git 작업
git add .
git commit -m "$commit_msg"

if $push_after; then
  current_branch=$(git rev-parse --abbrev-ref HEAD)
  git push origin "$current_branch"
fi

echo "✅ 커밋 완료: $commit_msg"
$push_after && echo "⬆️  push 완료"
