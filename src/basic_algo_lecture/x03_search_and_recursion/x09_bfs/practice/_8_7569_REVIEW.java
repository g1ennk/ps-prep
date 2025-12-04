package basic_algo_lecture.x03_search_and_recursion.x09_bfs.practice;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 토마토 (TRY:2)
public class _8_7569_REVIEW {

    static final int[][] DIRECTIONS = {
            {-1, 0, 0}, {1, 0, 0},
            {0, -1, 0}, {0, 1, 0},
            {0, 0, -1}, {0, 0, 1}
    };
    static int M, N, H;
    static int[][][] box;
    static int[][][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 가로 M, 세로 N, 높이 H 입력 (x,y,z)
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 2. 초기화
        box = new int[H][N][M];
        dist = new int[H][N][M];
        boolean isAllRipe = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 3. 토마토 정보 입력
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    box[z][y][x] = Integer.parseInt(st.nextToken());
                    dist[z][y][x] = -1;  // 초기 거리는 -1로 초기화

                    if (box[z][y][x] == 1) {
                        queue.offer(new int[]{z, y, x}); // 익은 토마토 위치 큐 삽입
                        dist[z][y][x] = 0; // 초기 방문 처리
                    }

                    // 안 익은 게 있는지 체크
                    if (box[z][y][x] == 0) isAllRipe = false;
                }
            }
        }

        // 4. 결과 판단 (이미 다 익은 경우 0, 최소일수, 익지 못하는 상황이면 -1)
        int answer = (isAllRipe) ? 0 : bfs(queue);

        // 5. 최종 출력
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static int bfs(ArrayDeque<int[]> queue) {
        int max = 0; // 최소일수

        // 탐색
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cz = cur[0], cy = cur[1], cx = cur[2];
            int cd = dist[cz][cy][cx];

            // 6방향 탐색
            for (int[] d : DIRECTIONS) {
                int nz = cz + d[0], ny = cy + d[1], nx = cx + d[2];
                int nd = cd + 1;

                // 범위 체크
                if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                // 벽 체크
                if (box[nz][ny][nx] == -1) continue;
                // 방문 여부 체크
                if (dist[nz][ny][nx] != -1) continue;

                // 방문 처리
                queue.offer(new int[]{nz, ny, nx});
                dist[nz][ny][nx] = nd;
                max = Math.max(max, nd);
            }
        }

        // 탐색 후 익지 못하는 경우
        if (isImpossibleToBeRipe()) {
            return -1;
        }

        return max;
    }

    private static boolean isImpossibleToBeRipe() {
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    // 방문하지 못했고, 토마토가 익지 못한 게 있다면
                    if (box[z][y][x] == 0 && dist[z][y][x] == -1) return true;
                }
            }
        }
        return false;
    }

}

/* 문제
- 3차원으로 z,y,x (6방향)
- 익은 토마토 인접한 곳에 익지 않은 토마토들이 영향을 받아 익게 됨
- 창고에 보관된 토마토들이 며칠이 지나면 모두 익는지 최소 일수를 구해야함
- 일부 칸에는 토마토가 들어있지 않을 수 있음
 */

/* 입출력
- 가로 M, 세로 N, 높이 H
- 토마토의 정보
- 1 = 익은 토마토, 0 = 익지 않은 토마토, -1 = 토마토가 들어있지 않음

- 이미 저장 때부터 모두 익었으면 0
- 토마토가 모두 익지 못하는 상황이면 -1
- 아니라면 최소 일수 출력
 */

/* 메모
- 동시 조건 항상 조심하기
 */