package barkingDog.x01_basic.level2;

import java.io.*;

public class BOJ_9498_시험성적 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 시험 점수 입력
        int score = Integer.parseInt(br.readLine());

        // 2. 결과 출력
        bw.write(solve(score));
        bw.flush();
    }

    static char solve(int score) {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }

}

