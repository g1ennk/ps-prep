package barkingDog.x02;

import java.io.*;
import java.util.StringTokenizer;

// 2480: 주사위 세개
public class _2480 {
    public static void main(String[] args) throws IOException {
        // 0. 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 3개의 눈 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 2. 상금 계산하기
        int prize = calculatePrize(a, b, c);

        // 3. 상금 출력하기
        bw.write(String.valueOf(prize));
        bw.flush();
    }

    static int calculatePrize(int a, int b, int c) {
        if (a == b && a == c) return 10000 + a * 1000;
        else if (a == b || a == c) return 1000 + a * 100;
        else if (b == c) return 1000 + b * 100;
        else return Math.max(Math.max(a, b), c) * 100;
    }
}
