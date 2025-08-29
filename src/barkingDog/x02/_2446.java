package barkingDog.x02;

import java.io.*;

// 2446: 별 찍기 - 9
public class _2446 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 2. 별 조합하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int k = 2 * i - (N - 1); k < N; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
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
- 공백: 0 1 2 3 4
- 별: 9 7 5 3 1
- 공백: 3 2 1 0
- 별: 3 5 7 9
 */