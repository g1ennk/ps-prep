package barkingDog.x08_more_stack;

import java.io.*;
import java.util.ArrayDeque;

// 3986: 좋은 단어
public class _3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 단어의 수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 2. 단어의 개수만큼 반복
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isGoodWord(br.readLine())) count++;
        }

        // 3. 출력하기
        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static boolean isGoodWord(String word) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }

        return stack.isEmpty();
    }
}
/* 문제 풀이
- 스택으로 인접한 같은 문자 쌍을 제거한다.
- 최종적으로 스택이 비면 좋은 단어, 아니면 나쁜 단어.
 */
