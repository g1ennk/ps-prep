package barkingDog.x02;

import java.io.*;

// 2442: 별 찍기 - 5
public class _2442 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 2. 별 조합하기
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = N; j > i; j--) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * i - 1; k++) {
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
공백 - 4 3 2 1 0
별 - 1 3 5 7 9
 */