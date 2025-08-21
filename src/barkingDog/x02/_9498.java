package barkingDog.x02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9498 {
    public static void main(String[] args) throws Exception {
        // 0. 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 점수 입력받기
        int score = Integer.parseInt(br.readLine());

        // 2. 결과 출력하기
        bw.write(getGrade(score));
        bw.flush();
    }

    // 학점 변환 메서드
    static char getGrade(int score) {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        else return 'F';
    }
}
