package barkingDog.x05_stack;

import java.io.*;
import java.util.ArrayDeque;

// 10773: 제로
public class _10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력횟수 K 입력받기
        int K = Integer.parseInt(br.readLine());

        // 2. 수행하기
        bw.write(String.valueOf(solution(K, br)));
        bw.flush();
    }

    private static int solution(int K, BufferedReader br) throws IOException {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        for (int i = 0; i < K; i++) {
            // 숫자 입력받기
            int number = Integer.parseInt(br.readLine());

            // 0인 경우 가장 최근 숫자 제거
            if (number == 0) {
                sum -= stack.pop();
                continue;
            }

            // 푸시
            stack.push(number);
            sum += number;
        }

        return sum;
    }
}

/* 문제풀이
- 핵심: 재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
- pop 및 push 연산과 동시에 합 구하기
- 0 일때 continue
 */
