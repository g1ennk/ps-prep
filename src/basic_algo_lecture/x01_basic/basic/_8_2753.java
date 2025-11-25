package basic_algo_lecture.x01_basic.basic;

import java.io.*;

// 윤년
public class _8_2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연도 입력
        int year = Integer.parseInt(br.readLine());

        // 윤년 판단
        int answer = isLeapYear(year);

        // 출력
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static int isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 1 : 0;
    }

}

/* 메모
- 윤년은 연도가 4의 배수이면서 100의 배수가 아닐 때 또는 400의 배수일 때이다.
- 조건식의 경우에도 논리 그룹을 명확하게 하기 위해 괄호로 더 명확하게 묶으면 가독성 및 안정성 증가
 */