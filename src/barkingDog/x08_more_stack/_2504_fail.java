package barkingDog.x08_more_stack;

import java.io.*;
import java.util.ArrayDeque;

// 2504: 괄호의 값
public class _2504_fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 괄호열을 나타내는 문자열 입력받기
        String line = br.readLine();

        // 2. 결과 출력하기
        bw.write(String.valueOf(solution(line)));
        bw.flush();
    }

    private static int solution(String line) {
        ArrayDeque<Object> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                int sum = 0;
                // 연속된 정수들을 더함
                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    sum += (Integer) stack.pop();
                }
                if (stack.isEmpty() || !(stack.peek() instanceof Integer)) {}
                // 여는 괄호가 나옴 (정수가 없었다면 2, 아니라면 2로 곱하기)
                stack.pop();
                int result = (sum == 0) ? 2 : sum * 2;
                stack.push(result);
            } else if (c == ']') {
                int sum = 0;
                // 연속된 정수들을 더함
                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    sum += (Integer) stack.pop();
                }
                // 여는 괄호가 나옴 (정수가 없었다면 3, 아니라면 3로 곱하기)
                stack.pop();
                int result = (sum == 0) ? 3 : sum * 3;
                stack.push(result);
            }
        }

        // 최종 계산
        int finalResult = 0;
        while (!stack.isEmpty()) {
            Object obj = stack.pop();
            // 정수가 아닌 괄호가 나온다면 올바르지 않은 입력
            if (!(obj instanceof Integer)) {
                return 0;
            }
            finalResult += (Integer) obj;
        }
        return finalResult;
    }
}

/*
- 올바른 괄호열: (), []
- 올바른 괄호열 안에 있는 애들도 올바른 괄호열
- 올바른 괄호열끼리 결합한 애들도 올바른 괄호열
- 정의
    - () = 2
    - [] = 3
    - (X) = 2 x 값
    - [X] = 3 x 값
    - (XY) = X + Y
- ex) (()[])([])

(()[[]])([])

(2[ ]

22 6

28
 */