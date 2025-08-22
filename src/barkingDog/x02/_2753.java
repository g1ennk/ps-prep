package barkingDog.x02;

import java.io.*;

// 2753: 윤년
public class _2753 {
    public static void main(String[] args) throws IOException {
        // 0. 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 연도 입력 받기
        int year = Integer.parseInt(br.readLine());

        // 2. 윤년 판단하기
        int answer = isLeapYear(year);

        // 3. 출력하기
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static int isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return 1;
        }

        return 0;
    }
}
