#!/usr/bin/env bash
set -euo pipefail

SRC_ROOT="src"
PKG_BASE="barkingDog"
SECTION="x005_stack"
FORCE=0

usage() {
  cat <<'EOF'
Usage:
  new_ps.sh -n <number> -t "<title>" [-s <section>] [-p <pkg_base>] [-r <src_root>] [-f]

Options:
  -n   문제 번호 (필수) 예: 10808
  -t   문제 이름 (선택) 예: "알파벳 개수"
  -s   섹션명 (기본: x02)
  -p   패키지 base (기본: barkingDog)
  -r   소스 루트 (기본: src)
  -f   기존 파일 덮어쓰기
EOF
}

while getopts ":n:t:s:p:r:fh" opt; do
  case $opt in
    n) NUMBER="$OPTARG" ;;
    t) TITLE="$OPTARG" ;;
    s) SECTION="$OPTARG" ;;
    p) PKG_BASE="$OPTARG" ;;
    r) SRC_ROOT="$OPTARG" ;;
    f) FORCE=1 ;;
    h) usage; exit 0 ;;
    \?) echo "Invalid option: -$OPTARG"; usage; exit 1 ;;
    :) echo "Option -$OPTARG requires argument."; usage; exit 1 ;;
  esac
done

if [[ -z "${NUMBER:-}" ]]; then
  echo "❌ 문제 번호(-n)가 필요합니다."
  exit 1
fi

PKG="${PKG_BASE}.${SECTION}"
DIR_PATH="${SRC_ROOT}/${PKG_BASE}/${SECTION}"
CLASS_NAME="_${NUMBER}"
JAVA_FILE="${DIR_PATH}/${CLASS_NAME}.java"

mkdir -p "${DIR_PATH}"

if [[ -f "${JAVA_FILE}" && "${FORCE}" -ne 1 ]]; then
  echo "⚠️ 이미 존재: ${JAVA_FILE} (덮어쓰려면 -f 옵션)"
  exit 1
fi

TITLE_COMMENT="${TITLE:-""}"
BAEKJOON_URL="https://www.acmicpc.net/problem/${NUMBER}"

cat > "${JAVA_FILE}" <<EOF
package ${PKG};

import java.io.*;

// ${NUMBER}: ${TITLE_COMMENT}
public class ${CLASS_NAME} {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // TODO: 문제 풀이 작성

        bw.flush();
    }
}
EOF

echo "✅ 생성 완료: ${JAVA_FILE}"
