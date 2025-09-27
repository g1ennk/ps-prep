package barkingDog.x05_stack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

// 2493: 탑
public class _2493_fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 탑의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2. 초기화 및 탑의 개수 입력받기
        int[] heights = new int[N + 1]; // 탑의 높이를 저장
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // 탑의 높이가 아닌 탑의 인덱스를 저장
        StringJoiner sj = new StringJoiner(" ");

        for (int i = 1; i <= N; i++) { // i = 5
            heights[i] = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }

            sj.add((stack.isEmpty()) ? "0" : String.valueOf(stack.peek()));

            stack.push(i);
        }

        // 3. 결과 출력하기
        bw.write(sj.toString());
        bw.flush();
    }
}
