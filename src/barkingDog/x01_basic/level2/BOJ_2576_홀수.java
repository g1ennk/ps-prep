package barkingDog.x01_basic.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2576_홀수 {

    static final int N = 7; // 7개의 자연수

    static int min = Integer.MAX_VALUE;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 7개의 자연수를 입력과 동시에 홀수인 값들을 합에 누적하고, 최댓값 갱신
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (isOdd(num)) {
                sum += num;
                min = Math.min(min, num);
            }
        }

        // 2. 결과 출력
        if (sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum + "\n" + min);
    }

    static boolean isOdd(int num) {
        return num % 2 == 1;
    }

}
