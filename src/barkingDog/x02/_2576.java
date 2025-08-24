package barkingDog.x02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2576: 홀수
public class _2576 {

    static final int N = 7;

    public static void main(String[] args) throws Exception {
        // 0. 초기세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 7개의 자연수 입력 받기
        int sum = 0;
        int minOdd = Integer.MAX_VALUE;

        // 2. 홀수 판단 후 연산하기
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (isOdd(num)) {
                sum += num;
                minOdd = Math.min(minOdd, num);
            }
        }

        // 3. 결과 조합 후 출력하기
        if (sum == 0) {
           bw.write("-1");
        } else {
          bw.write(sum + "\n" + minOdd);
        }
        bw.flush();
    }

    static boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
