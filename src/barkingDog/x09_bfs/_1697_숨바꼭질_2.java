package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1697: 숨바꼭질
public class _1697_숨바꼭질_2 {

    static final int maxDist = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수빈이의 위치 N과 동생의 위치 K 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈
        int K = Integer.parseInt(st.nextToken()); // 동생

        // 2. 결과 출력하기
        bw.write(String.valueOf(solution(N, K)));
        bw.flush();
    }

    static int solution(int N, int K) {
        int[] dist = new int[maxDist + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();

        // 1. 수빈이와 동생 초기 방문 처리
        dist[N] = 0;
        q.offer(N);

        // 2. 동생 위치 찾기
        while (!q.isEmpty()) {
            int curr = q.poll();

            // 종료 조건 (수빈이가 동생을 찾을 때)
            if (curr == K) return dist[curr];

            // 3 방향 탐색
            int[] dir = {curr - 1, curr + 1, curr * 2};
            for (int next : dir) {
                // 예외 처리
                if (next < 0 || next > maxDist) continue;
                if (dist[next] != -1) continue;

                // 방문 처리
                dist[next] = dist[curr] + 1;
                q.offer(next);
            }
        }

        return -1; // 도달 불가능
    }
}