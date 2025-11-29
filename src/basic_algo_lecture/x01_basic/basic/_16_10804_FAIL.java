package basic_algo_lecture.x01_basic.basic;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

// 카드 역배치(TRY:2)
public class _16_10804_FAIL {

    // static
    static final int CARD_LENGTH = 20;
    static final int INPUT_COUNT = 10;
    static int[] CARD = new int[CARD_LENGTH];

    static {
        for (int i = 0; i < CARD_LENGTH; i++) {
            CARD[i] = i + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 10개의 구간 입력 + 뒤집기
        for (int i = 0; i < INPUT_COUNT; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 1-based → 0-based
            int begin = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            reverse(begin, end);
        }

        // 2. 출력
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < CARD.length; i++) {
            sj.add(String.valueOf(CARD[i]));
        }
        bw.write(sj.toString());
        bw.flush();
    }

    // SWAP
    private static void reverse(int begin, int end) {
        while (begin < end) {
            int temp = CARD[begin];
            CARD[begin] = CARD[end];
            CARD[end] = temp;
            begin++;
            end--;
        }
    }
}

/* 메모
문제
- 1부터 20까지의 카드 (오름차순 정렬)
- a,b가 주어지면 a부터 b까지의 카드를 역순으로 놓는다.

입력
- 10개의 줄에 걸쳐 구간 주어짐
- 시작 위치와 끝 위치

출력
- 20개의 카드 공백을 두고 출력

예시
2 4 (begin, end) -> 1,3 인덱스
0 1 2 3 4 index
1 2 3 4 5 card
1 2 3 4 5 copy

개념
- SWAP 개념
- static 블록으로 직접 초기화보다 메서드 방식으로 초기화
 */
