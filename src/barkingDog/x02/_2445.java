package barkingDog.x02;

import java.io.*;

// 2445: 별 찍기 - 8
public class _2445 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 2. 별 조합하기
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            for (int k = N; k > 2 * i - N; k--) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                sb.append("*");
            }
            for (int k = 0; k < 2 * i - 2; k++) {
                sb.append(" ");
            }
            for (int j = i; j <= N; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }


        // 3. 별 출력하기
        bw.write(sb.toString());
        bw.flush();
    }
}
/* 문제풀이
- 별: 1 2 3 4 5
- 공백: 8 6 4 2 0 2 4 6 8
- 별: 1 2 3 4 5
 */