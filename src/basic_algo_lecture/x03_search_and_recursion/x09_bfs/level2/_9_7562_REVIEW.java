package basic_algo_lecture.x03_search_and_recursion.x09_bfs.level2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나이트의 이동 (TRY:2)
public class _9_7562_REVIEW {

    // 8방향
    static final int[][] DIRECTIONS = {
            {-2, 1}, {-1, 2},
            {1, 2}, {2, 1},
            {2, -1}, {1, -2},
            {-1, -2}, {-2, -1}
    };
    static int X; // 체스판 크기
    static int[][] dist; // 방문 및 거리 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());

        // 2. 테스트 케이스 수행
        for (int i = 0; i < T; i++) {
            // 2.1. 체스판의 크기 입력
            X = Integer.parseInt(br.readLine());

            // 2.2. dist 배열 초기화
            for (int x = 0; x < X; x++) {
                Arrays.fill(dist[x], -1);
            }

            // 2.3. 나이트 시작 칸 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            // 2.4. 나이트 도착 칸 입력
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            // 2.5. 나이트가 최소 몇 번만에 이동할 수 있는지 구하기
            bw.write(solution(sx, sy, tx, ty) + "\n");
        }

        // 3. 최종 출력
        bw.flush();
    }

    static int solution(int sx, int sy, int tx, int ty) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 초기 방문 처리
        queue.offer(new int[]{sy, sx});
        dist[sy][sx] = 0;

        // 탐색
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1], cd = dist[cy][cx];

            // 탈출 조건 체크
            if (cy == ty && cx == tx) return cd;

            for (int[] d : DIRECTIONS) {
                int ny = cy + d[0];
                int nx = cx + d[1];
                int nd = cd + 1;

                // 범위 체크
                if (ny < 0 || ny >= X || nx < 0 || nx >= X) continue;
                // 방문 여부 체크
                if (dist[ny][nx] != -1) continue;

                // 방문 처리
                queue.offer(new int[]{ny, nx});
                dist[ny][nx] = nd;
            }
        }

        // 도달 불가능
        return -1;
    }

}

/* 문제
- 테스트 케이스의 수 T
- 체스판의 크기 x
- 나이트가 현재 있는 칸
- 나이트가 이동하려는 칸
- 각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는 지 출력
 */

/* 메모

 */