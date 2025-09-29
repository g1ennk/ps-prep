package barkingDog.x07_deck;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1021: 회전하는 큐
public class _1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 큐의 크기 N 입력받고 큐 초기화
        ArrayDeque<Integer> deck = new ArrayDeque<>();
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken());
        for (int i = 1; i <= N; i++) deck.addLast(i);

        // 2. 뽑아내려고 하는 수의 개수 M 입력받기
        int M = Integer.parseInt(firstLine.nextToken());

        // 3. 뽑아내려고 하는 수 입력을 받음과 동시에 처리
        StringTokenizer secondLine = new StringTokenizer(br.readLine());
        int minCal = 0; // 최소 연산의 개수의 합
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(secondLine.nextToken()); // 타겟

            // 타겟의 인덱스 찾기
            int targetIndex = 0;
            for (Integer number : deck) {
                if (number == target) break;
                targetIndex++;
            }

            // 왼쪽으로 뺄지 오른쪽으로 뺄지 결정하고, 작은 거 기준으로 연산 총합에 더하고 연산 수행
            int left = targetIndex;
            int right = deck.size() - targetIndex;

            if (left <= right) {
                minCal += left;
                for (int j = 0; j < left; j++) {
                    deck.addLast(deck.removeFirst());
                }
            } else {
                minCal += right;
                for (int j = 0; j < right; j++) {
                    deck.addFirst(deck.removeLast());
                }
            }

            // 이후 타겟 번호 뽑기
            deck.removeFirst();
        }

        // 4. 출력하기
        bw.write(String.valueOf(minCal));
        bw.flush();
    }
}