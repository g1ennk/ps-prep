package barkingDog.x02;

import java.io.*;

// 2444: 별 찍기 - 7
public class _2444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 2. 별 조합하기
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            for (int j = N; j > i; j--) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * i - 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = N; i > 0; i--) {
            for (int j = N - i; j > 0; j--) {
                sb.append(" ");
            }
            for (int k = 2 * i - 1; k > 0; k--) {
                sb.append("*");
            }
            sb.append("\n");
        }

        // 3. 별 출력하기
        bw.write(sb.toString());
        bw.flush();
    }
}