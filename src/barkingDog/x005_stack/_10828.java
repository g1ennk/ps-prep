package barkingDog.x005_stack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 10828: 스택
public class _10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 명령의 수 N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 2. 명령어 수행하기
        bw.write(solution2(N, br));

        // 3. 출력하기
        bw.flush();
    }

    // 구현으로 풀기
    private static String solution1(int N, BufferedReader br) throws IOException {
        // 초기화
        String[] stack = new String[N];
        int top = -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    String item = st.nextToken();
                    stack[++top] = item;
                    break;
                case "pop":
                    if (top == -1) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(stack[top--]).append("\n");
                    break;
                case "size":
                    sb.append(top + 1).append("\n");
                    break;
                case "empty":
                    sb.append((top == -1) ? "1\n" : "0\n");
                    break;
                case "top":
                    if (top == -1) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(stack[top]).append("\n");
                    break;
            }
        }

        return sb.toString();
    }

    private static String solution2(int N, BufferedReader br) throws IOException {
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    stack.push(st.nextToken());
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append((stack.isEmpty()) ? "1\n" : "0\n");
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(stack.peek()).append("\n");
            }
        }

        return sb.toString();
    }

}

