package basic_algo_lecture.x01_basic.basic;

import java.io.*;

// 홀수(TRY:2)
public class _11_2576_DONE {

    static final int N = 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 + 풀이
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number % 2 != 0) {
                sum += number;
                min = Math.min(min, number);
            }
        }

        // 출력
        if (sum == 0) {
            bw.write("-1");
            bw.flush();
            return;
        }
        bw.write(sum + "\n" + min);
        bw.flush();
    }
}

/* 메모
- 7개의 자연수
- 홀수 판별 -> 전체 합 -> 최솟값
- 홀수가 존재하지 않는 경우 -1 출력
 */
