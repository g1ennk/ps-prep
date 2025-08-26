package barkingDog.x02;

import java.io.*;
import java.util.StringTokenizer;

// 1267: 핸드폰 요금
public class _1267_again {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 통화의 개수 N 입력 받은 후, 통화 목록 입력 받기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2. 각 요금제 계산하기
        int y = 0, m = 0;
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            y += ((t / 30) + 1) * 10;
            m += ((t / 60) + 1) * 15;
        }

        // 2. 결과 출력하기
        if (y < m) bw.write("Y " + y);
        else if (y > m) bw.write("M " + m);
        else bw.write("Y M " + m);
        bw.flush();
    }

}
