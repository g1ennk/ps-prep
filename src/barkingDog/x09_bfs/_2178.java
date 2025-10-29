package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 2178: 미로 탐색 (거리 측정)
public class _2178 {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] maze;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 미로의 크기 N과 M 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2. 초기화
        maze = new int[N][M];
        visited = new boolean[N][M];

        // 3. 미로 정보 입력 받기
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                maze[r][c] = line.charAt(c) - '0'; // char -> int 변환
            }
        }

        // 4. 결과 출력하기
        bw.write(String.valueOf(bfs(0, 0)));
        bw.flush();
    }

    static int bfs(int startX, int startY) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        maze[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currDist = maze[currX][currY];

            if (currX == N - 1 && currY == M - 1) return currDist; // 배열 0부터 시작하기 때문에

            for (int[] dir : DIR) {
                int nx = currX + dir[0];
                int ny = currY + dir[1];
                int nextDist = currDist + 1;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (maze[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                maze[nx][ny] = nextDist;
            }
        }

        return 0;
    }
}
