package barkingDog.x08_more_stack;

import java.io.*;
import java.util.ArrayDeque;

// 9012: 괄호
public class _9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 수 입력받기
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(isVPS(br.readLine())).append('\n');
        }

        // 2. 출력하기
        bw.write(sb.toString());
        bw.flush();
    }

    private static String isVPS(String line) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            // 여는 괄호는 무조건 push
            if (c == '(') {
                stack.push(c);
            }
            // 닫는 괄호인 경우(비어 있거나 짝이 안 맞는 경우 조기 반환)
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return "NO";
                stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}
