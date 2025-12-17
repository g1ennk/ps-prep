package basic_algo_lecture.x03_search_and_recursion.x09_bfs.level3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기 (TRY:1)
public class BOJ_2206_벽_부수고_이동하기_1_FAIL {

    // 맵 관련
    static final int WALL = 1;
    static final int EMPTY = 0;
    static final int UNVISITED = -1;
    static int N, M; // Y,X
    static int[][] map;

    // broken 상태
    static final int UNBROKEN = 0; // 아직 벽을 안 부순 상태
    static final int BROKEN = 1;     // 이미 벽을 한 번 부순 상태

    // 상하좌우
    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2. 맵 정보 입력
        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = line.charAt(x) - '0';
            }
        }

        // 3. 출력
        bw.write(String.valueOf(solution()));
        bw.flush();
    }

    static int solution() {
        // 초기화
        int[][][] dist = new int[N][M][2];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                dist[y][x][UNBROKEN] = UNVISITED;
                dist[y][x][BROKEN] = UNVISITED;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();

        // 초기 방문 처리
        dist[0][0][UNBROKEN] = 1; // 시작칸 포함이기 때문에 1
        q.offer(new int[]{0, 0, UNBROKEN}); // sy, sx, unbroken

        // 탐색
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0], cx = cur[1];
            int brokenStatus = cur[2];
            int cd = dist[cy][cx][brokenStatus];

            // 탈출 조건 (0-base)
            if (cy == N - 1 && cx == M - 1) return cd;

            // 4방향
            for (int[] d : DIR) {
                int ny = cy + d[0], nx = cx + d[1];
                int nd = cd + 1;

                // 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                // 빈 칸 이동
                if (map[ny][nx] == EMPTY
                        && dist[ny][nx][brokenStatus] == UNVISITED) {
                    dist[ny][nx][brokenStatus] = nd;
                    q.offer(new int[]{ny, nx, brokenStatus});
                }

                // 벽 부수고 이동
                if (map[ny][nx] == WALL
                        && brokenStatus == UNBROKEN
                        && dist[ny][nx][BROKEN] == UNVISITED) {
                    dist[ny][nx][BROKEN] = nd;
                    q.offer(new int[]{ny, nx, BROKEN});
                }
            }
        }

        // 불가능할 때 -1 반환
        return -1;
    }


}

/* 메모
- NxM 행렬 맵
- 0 = 이동 가능, 1 = 이동 불가능 벽
- 시작 위치(1,1), 타겟 위치(N,M) 최단 경로 이동(시작하는 칸과, 끝나는 칸까지 포함)
- 0-base: 시작 위치(0,0), 타겟 위치(N-1, M-1) -> current 기준으로
- 벽을 한 개까지 부숴 이동 가능 for 최단경로
- 이동은 상하좌우
 */