package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1697: 숨바꼭질
public class _1697_숨바꼭질 {

    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수빈 위치 N과 동생 위치 K 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 초기 위치
        int K = Integer.parseInt(st.nextToken()); // 타겟 위치

        // 2. 그래프 초기화
        int[] dir = {-1, 1, 2};
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        // 3. 초기 방문 처리
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        dist[N] = 0;

        // 4. 탐색
        while (!q.isEmpty()) {
            int cur = q.poll();
            int curDist = dist[cur];

            if (cur == K) break; // 종료 조건

            // 세 방향 탐색
            for (int d : dir) {
                int next = cur + d;
                int nextDist = curDist + 1;

                if (d == 2) next = cur * d;

                if (next < 0 || next > MAX) continue;
                if (dist[next] != -1) continue;

                q.offer(next);
                dist[next] = nextDist;
            }
        }

        // 5. 출력
        bw.write(String.valueOf(dist[K]));
        bw.flush();
    }
}
/*
- 수빈이는 N,  동생은 K
- 걷기 -> X-1 or X+1
- 순간이동 -> 2*X
- 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 호 후인지 구하는 프로그램

- dist 필요
- dir이 상하좌우 뿐만 아니라 순간이동까지 고려
- 그래프가 아닌 X만 고려
 */