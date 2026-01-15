package barkingDog.x03_search_and_recursion.bfs.level1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색_2 {

    static int N, M;
    static int targetY, targetX;
    static int[][] maze;
    static int[][] dist;

    static final int WALL = 0;
    static final int UNVISITED = -1;
    static final int START_Y = 0, START_X = 0;
    static final int[][] DIR4 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력: N, M
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2. 초기화: N, M에 따른 초기화
        targetY = N - 1;
        targetX = M - 1;
        maze = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], UNVISITED);
        }

        // 3. 입력: 미로 정보
        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < M; x++) {
                maze[y][x] = line.charAt(x) - '0';
            }
        }

        // 4. 풀이 및 출력
        bw.write(String.valueOf(solve()));
        bw.flush();
    }

    static int solve() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 시작 위치 초기 방문 처리
        dist[START_Y][START_X] = 1;
        queue.offer(new int[]{START_Y, START_X});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1];

            // 종료조건 체크
            if (cy == targetY && cx == targetX) return dist[cy][cx];

            // 4방향
            for (int[] d : DIR4) {
                int ny = cy + d[0], nx = cx + d[1];

                // 예외 처리
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (maze[ny][nx] == WALL) continue;
                if (dist[ny][nx] != UNVISITED) continue;

                // 방문 처리
                dist[ny][nx] = dist[cy][cx] + 1;
                queue.offer(new int[]{ny, nx});
            }
        }

        // 도달 불가능
        return -1;
    }

}
