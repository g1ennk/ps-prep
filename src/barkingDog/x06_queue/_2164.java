package barkingDog.x06_queue;

import java.io.*;
import java.util.ArrayDeque;

// 2164: 카드2
public class _2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 2. 카드 놓기
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        // 3. 카드가 1장 남을 때까지 반복
        while (q.size() != 1) {
            // 맨 위 카드 버리기
            q.pollFirst();
            // 다음 맨 위 카드를 맨 아래로 놓기
            q.addLast(q.pollFirst());
        }

        // 4. 출력하기
        bw.write(String.valueOf(q.peek()));
        bw.flush();
    }
}