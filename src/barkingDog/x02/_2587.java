package barkingDog.x02;

import java.io.*;
import java.util.Arrays;

// 2587: 대표값2
public class _2587 {

    static final int N = 5;
    static final int MID_INDEX = (N - 1) / 2;

    public static void main(String[] args) throws IOException {
        // 0. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numbers = new int[N];

        // 1. 5개의 자연수 입력 받기
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            numbers[i] = num;
        }

        // 2. 평균값 계산하기
        int avg = sum / N;

        // 3. 중간값 계산하기
        Arrays.sort(numbers);
        int midian = numbers[MID_INDEX];

        // 4. 결과 출력하기
        bw.write(avg + "\n" + midian);
        bw.flush();
    }
}

/* 문제풀이
평균값과 중간값 구하기
 */