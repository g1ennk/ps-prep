package barkingDog.x02;

import java.io.*;

// 2443: 별 찍기 - 6
public class _2443 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 2. 별 조합하기
        StringBuilder sb = new StringBuilder();
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
/* 문제 풀이
공백 - 0 1 2 3 4
별 - 9 7 5 3 1
 */