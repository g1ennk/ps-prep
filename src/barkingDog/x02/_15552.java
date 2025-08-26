package barkingDog.x02;

import java.io.*;
import java.util.StringTokenizer;

// 15552번: 빠른 A+B
public class _15552 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 입력받기
        int T = Integer.parseInt(br.readLine());

        // 2. A+B 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a + b).append("\n");
        }

        // 3. 출력하기
        bw.write(sb.toString());
        bw.flush();
    }
}
