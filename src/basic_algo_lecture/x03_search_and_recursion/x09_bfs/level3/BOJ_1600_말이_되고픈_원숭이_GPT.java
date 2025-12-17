package basic_algo_lecture.x03_search_and_recursion.x09_bfs.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1600_말이_되고픈_원숭이_GPT {

    static final int[][] HORSE_DIR8 = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };
    static final int[][] MONKEY_DIR4 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static final int START_X = 0, START_Y = 0;
    static final int OBSTACLE = 1;
    static final int UNVISITED = -1;

    // ===== DEBUG FLAGS =====
    static final boolean DEBUG = true;
    static final int POP_LIMIT = 200;       // poll 로그 최대 개수
    static final int PUSH_LIMIT = 400;      // push 로그 최대 개수
    static final int PRINT_EVERY = 1;       // poll 로그를 N번마다 출력 (1이면 매번)

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

        if (DEBUG) {
            System.out.println("========== [DEBUG] INPUT ==========");
            System.out.println("[DEBUG] K=" + K + " W=" + W + " H=" + H);
            System.out.println("[DEBUG] start=(" + START_Y + "," + START_X + ") val=" + board[START_Y][START_X]);
            System.out.println("[DEBUG] end=(" + END_Y + "," + END_X + ") val=" + board[END_Y][END_X]);
            System.out.println("===================================");
        }

        int answer = solve();
        System.out.println(answer);
    }

    static int solve() {
        // (1) 시작/도착이 장애물이면 바로 -1 (디버깅 + 안전)
        if (board[START_Y][START_X] == OBSTACLE || board[END_Y][END_X] == OBSTACLE) {
            if (DEBUG) System.out.println("[DEBUG] start/end is obstacle -> return -1");
            return -1;
        }

        // 거리 배열 초기화
        int[][][] dist = new int[H][W][K + 1];
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                Arrays.fill(dist[y][x], UNVISITED);
            }
        }

        // 시작지점 초기화
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        dist[START_Y][START_X][0] = 0; // 방문 처리(거리 확정) = enqueue 시점
        queue.offer(new int[]{START_Y, START_X, 0});

        // ===== DEBUG COUNTERS =====
        int popCnt = 0;
        int pushCnt = 0;

        // while
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1], ck = cur[2];

            // 이상 상태 방어 (절대 나오면 안 됨)
            if (dist[cy][cx][ck] == UNVISITED) {
                throw new RuntimeException("[BUG] polled UNVISITED state: y=" + cy + " x=" + cx + " k=" + ck);
            }

            // poll 로그
            popCnt++;
            if (DEBUG && popCnt <= POP_LIMIT && (popCnt % PRINT_EVERY == 0)) {
                System.out.printf("[POP #%d] y=%d x=%d k=%d dist=%d q=%d%n",
                        popCnt, cy, cx, ck, dist[cy][cx][ck], queue.size());
            }

            // 종료조건
            if (cy == END_Y && cx == END_X) {
                if (DEBUG) {
                    System.out.println("[DEBUG] reached END at pop #" + popCnt + " (k=" + ck + ")");
                }
                return dist[cy][cx][ck];
            }

            // 4방향
            for (int[] d : MONKEY_DIR4) {
                int ny = cy + d[0], nx = cx + d[1];

                // 필터 로그(선택): 왜 continue 되는지 보고 싶으면 주석 해제
                /*
                if (DEBUG && popCnt <= POP_LIMIT) {
                    if (ny < 0 || ny >= H || nx < 0 || nx >= W) System.out.println("  [SKIP-4] OOB");
                    else if (board[ny][nx] == OBSTACLE) System.out.println("  [SKIP-4] OBSTACLE");
                    else if (dist[ny][nx][ck] != UNVISITED) System.out.println("  [SKIP-4] VISITED");
                }
                */

                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if (board[ny][nx] == OBSTACLE) continue;
                if (dist[ny][nx][ck] != UNVISITED) continue;

                dist[ny][nx][ck] = dist[cy][cx][ck] + 1;
                queue.offer(new int[]{ny, nx, ck});

                pushCnt++;
                if (DEBUG && pushCnt <= PUSH_LIMIT) {
                    System.out.printf("  [PUSH-4 #%d] -> y=%d x=%d k=%d dist=%d%n",
                            pushCnt, ny, nx, ck, dist[ny][nx][ck]);
                }
            }

            // 8방향 (말 이동)
            if (ck < K) {
                int nk = ck + 1;
                for (int[] d : HORSE_DIR8) {
                    int ny = cy + d[0], nx = cx + d[1];

                    // 필터 로그(선택): 왜 continue 되는지 보고 싶으면 주석 해제
                    /*
                    if (DEBUG && popCnt <= POP_LIMIT) {
                        if (ny < 0 || ny >= H || nx < 0 || nx >= W) System.out.println("  [SKIP-8] OOB");
                        else if (board[ny][nx] == OBSTACLE) System.out.println("  [SKIP-8] OBSTACLE");
                        else if (dist[ny][nx][nk] != UNVISITED) System.out.println("  [SKIP-8] VISITED");
                    }
                    */

                    if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                    if (board[ny][nx] == OBSTACLE) continue;
                    if (dist[ny][nx][nk] != UNVISITED) continue;

                    dist[ny][nx][nk] = dist[cy][cx][ck] + 1;
                    queue.offer(new int[]{ny, nx, nk});

                    pushCnt++;
                    if (DEBUG && pushCnt <= PUSH_LIMIT) {
                        System.out.printf("  [PUSH-8 #%d] -> y=%d x=%d k=%d dist=%d%n",
                                pushCnt, ny, nx, nk, dist[ny][nx][nk]);
                    }
                }
            }
        }

        if (DEBUG) {
            System.out.println("[DEBUG] queue exhausted. popCnt=" + popCnt + ", pushCnt=" + pushCnt);
        }
        // 도달 불가 시 -1 반환
        return -1;
    }
}
