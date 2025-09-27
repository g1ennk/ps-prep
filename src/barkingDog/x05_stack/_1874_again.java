package barkingDog.x05_stack;

import java.io.*;
import java.util.ArrayDeque;

// 1874: 스택 수열
public class _1874_again {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 제출 시 solution2 사용
        bw.write(solution2(n, br));
        bw.flush();
    }

    /**
     * solution1: queue 기반 풀이
     * 입력 전체를 큐에 저장하고, 1~n까지 push하면서 큐 front와 같으면 pop
     */
    private static String solution1(ArrayDeque<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int n = queue.size();

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");

            // 스택 top과 목표값이 같을 동안 pop
            while (!stack.isEmpty() && !queue.isEmpty()
                    && stack.peek().equals(queue.peek())) {
                stack.pop();
                queue.poll();
                sb.append("-\n");
            }
        }

        return stack.isEmpty() ? sb.toString() : "NO";
    }

    /**
     * solution2: current 기반 풀이
     * 입력을 즉시 처리하면서 마지막 push 숫자를 current로 관리
     */
    private static String solution2(int n, BufferedReader br) throws IOException {
        int current = 1; // 마지막으로 push한 숫자
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(br.readLine());

            // next까지 push
            while (current <= next) {
                stack.push(current++);
                sb.append("+\n");
            }

            // top이 next여야 pop 가능
            if (!stack.isEmpty() && stack.peek() == next) {
                stack.pop();
                sb.append("-\n");
            }
        }

        return stack.isEmpty() ? sb.toString() : "NO";
    }
}
