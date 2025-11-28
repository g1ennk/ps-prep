package basic_algo_lecture.x01_basic.basic;

import java.io.*;

// 시험 성적
public class _6_9498_DONE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 시험 점수 입력
        int score = Integer.parseInt(br.readLine());

        // 시험 등급 판별
        char grade = getGrade(score);

        // 출력
        bw.write(String.valueOf(grade));
        bw.flush();
    }

    private static char getGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        return 'F';
    }
}


