package barkingDog.x03_search_and_recursion.bfs.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2206_벽_부수고_이동하기_2_REVIEW {

    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int SX = 0, SY = 0;
    static final int BROKEN = 1;
    static final int UNBROKEN = 0;
    static final int UNVISITED = -1;
    static final int[][] DIR4 = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    static int N, M; // Y,X
    static int tx, ty;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tx = M - 1;
        ty = N - 1;

        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = line.charAt(x) - '0';
            }
        }

        System.out.println(solve());
    }

    static int solve() {
        // 거리 배열 초기화
        int[][][] dist = new int[N][M][2];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                dist[y][x][UNBROKEN] = UNVISITED;
                dist[y][x][BROKEN] = UNVISITED;
            }
        }

        // 초기 방문 처리
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        dist[SY][SX][UNBROKEN] = 1;
        queue.offer(new int[]{SY, SX, UNBROKEN});

        // while
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1];
            int cs = cur[2];
            int cd = dist[cy][cx][cs];

            // 탈출 조건
            if (cy == ty && cx == tx) return cd;

            for (int[] d : DIR4) {
                int ny = cy + d[0], nx = cx + d[1];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                // 빈 칸 이동 (상태 유지)
                if (map[ny][nx] == EMPTY && dist[ny][nx][cs] == UNVISITED) {
                    dist[ny][nx][cs] = cd + 1;
                    queue.offer(new int[]{ny, nx, cs});
                }

                // 벽 부수고 이동 (UNBROKEN -> BROKEN)
                if (map[ny][nx] == WALL
                        && cs == UNBROKEN
                        && dist[ny][nx][BROKEN] == UNVISITED) {
                    dist[ny][nx][BROKEN] = cd + 1;
                    queue.offer(new int[]{ny, nx, BROKEN});
                }
            }
        }

        // 불가능할 때 -1 반환
        return -1;
    }

}

/*
- NxM으로 표현되는 맵
- 0은 이동할 수 있는 곳, 1은 이동할 수 없는 벽
- 시작위치는 (1,1), 목표 위치는 (N,M)
- 최단경로 이동 -> dist
- 시작하는 칸과 끝나는 칸까지 포함
- 벽을 한 개까지 부수고 이동 가능 -> 3차원 배열
- 최단거리를 출력하되 불가능할 때는 -1 출력
 */