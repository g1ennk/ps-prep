package basic_algo_lecture.x03_search_and_recursion.x09_bfs.level3;

import java.util.*;
import java.io.*;

public class BOJ_1600_말이_되고픈_원숭이_1_REVIEW {

    static final int[][] HORSE_DIR8 = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };
    static final int[][] MONKEY_DIR4 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static final int START_X = 0, START_Y = 0;
    static final int OBSTACLE = 1;
    static final int UNVISITED = -1;

    static int K;
    static int W, H;
    static int END_X, END_Y;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        END_X = W - 1;
        END_Y = H - 1;

        board = new int[H][W];
        for (int y = 0; y < H; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < W; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }

    static int solve() {
        // 거리 배열 초기화
        int[][][] dist = new int[H][W][K + 1];
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                Arrays.fill(dist[y][x], -1);
            }
        }

        // 시작지점 초기화
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        dist[START_Y][START_X][0] = 0;
        queue.offer(new int[]{START_Y, START_X, 0});

        // while
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1], ck = cur[2];

            // 종료조건
            if (cy == END_Y && cx == END_X) return dist[cy][cx][ck];

            // 4방향
            for (int[] d : MONKEY_DIR4) {
                int ny = cy + d[0], nx = cx + d[1];

                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if (board[ny][nx] == OBSTACLE) continue;
                if (dist[ny][nx][ck] != UNVISITED) continue;

                dist[ny][nx][ck] = dist[cy][cx][ck] + 1;
                queue.offer(new int[]{ny, nx, ck});
            }

            // 8방향
            if (ck < K) {
                for (int[] d : HORSE_DIR8) {
                    int ny = cy + d[0], nx = cx + d[1], nk = ck + 1;

                    if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                    if (board[ny][nx] == OBSTACLE) continue;
                    if (dist[ny][nx][nk] != UNVISITED) continue;

                    dist[ny][nx][nk] = dist[cy][cx][ck] + 1;
                    queue.offer(new int[]{ny, nx, nk});
                }
            }
        }

        // 도달 불가 시 -1 반환
        return -1;
    }

}

/* 메모
- 말의 이동방식 = 나이트 (8개)
- K번만 말처럼 움직일 수 있음 = 3차원
- 그 외에는 인접한 칸 = 4방향

- K -> 격자판 크기 W,H -> 격자판
- 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 방법
 */
