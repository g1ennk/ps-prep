package barkingDog.x08_more_stack;

import java.io.*;
import java.util.ArrayDeque;

// 4949: 균형잡힌 세상
public class _4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 온점이 들어올 때까지 반복
        StringBuilder sb = new StringBuilder();
        while (true) {
            // 문자열 입력받기
            String line = br.readLine();

            // 종료조건 체크
            if (line.equals("."))
                break;

            // 균형이 맞는지 확인
            sb.append(solution(line)).append("\n");
        }

        // 2. 최종 결과 출력
        bw.write(sb.toString());
        bw.flush();
    }

    private static String solution(String line) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            // 여는 괄호는 무조건 push
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            // 닫는 소괄호인 경우(비어 있거나 짝이 안 맞는 경우 조기 반환)
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return "no";
                stack.pop();
            }
            // 닫는 대괄호인 경우(비어 있거나 짝이 안 맞는 경우 조기 반환)
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return "no";
                stack.pop();
            }
            // 괄호가 아닌 문자들은 무시
        }

        // 최종 스택 체크
        return (stack.isEmpty()) ? "yes" : "no";
    }
}
/* 문제 풀이 (괄호쌍 문제)
- 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단한다.
- 괄호는 소괄호()와 대괄호[] 두 종류이다.
- 마지막 라인에 .이 들어올 때까지 반복
- 균형이면 yes, 아니면 no
 */