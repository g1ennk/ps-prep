package barkingDog.x01_basic.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2753_윤년 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 연도 입력
        int year = Integer.parseInt(br.readLine());

        // 2. 출력
        System.out.println(isLeapYear(year));
    }

    static int isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) return 1;
        return 0;
    }

}

/*
윤년이란?
- 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
 */