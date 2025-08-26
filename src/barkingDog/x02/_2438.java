package barkingDog.x02;

import java.io.*;

// 2438: 별 찍기 - 1
public class _2438 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 2. 별 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
