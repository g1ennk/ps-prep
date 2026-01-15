package barkingDog.x03_search_and_recursion.bfs.level1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 숨바꼭질(TRY:2)
public class _5_1697_REVIEW {

    // static
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수빈이와 동생의 위치 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        // 2. 초기화
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        // 3. 초기 방문 처리
        queue.offer(N);
        dist[N] = 0;

        // 4. BFS
        while (!queue.isEmpty()) {
            int cx = queue.poll();
            int cd = dist[cx];

            // 종료 조건 (수빈이가 동생을 찾았을 때)
            if (cx == K) {
                bw.write(String.valueOf(cd));
                bw.flush();
                return;
            }

            int[] dir = {cx + 1, cx - 1, 2 * cx}; // 앞, 뒤, 순간이동
            for (int nx : dir) {
                // 다음 시간
                int nd = cd + 1;

                // 범위 체크
                if (nx < 0 || nx > MAX) continue;
                // 방문 여부 체크
                if (dist[nx] != -1) continue;

                // 방문 처리
                queue.offer(nx);
                dist[nx] = nd;
            }
        }
    }
}
