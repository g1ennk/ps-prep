package barkingDog.x02;

import java.io.*;
import java.util.StringTokenizer;

// 10869: 사칙연산
public class _10869 {
    public static void main(String[] args) throws IOException {
        // 0. 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 자연수 A와 B 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 2. +,-,*,/,% 연산
        bw.write(A + B + "\n");
        bw.write(A - B + "\n");
        bw.write(A * B + "\n");
        bw.write(A / B + "\n");
        bw.write(A % B + "\n");

        // 3. 출력하기
        bw.flush();
    }
}
