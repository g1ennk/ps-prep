package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1012: 유기농 배추
public class _1012_0 {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] grid;
    static boolean[][] visited;
    static int N, M; // N: 행(세로,column), M: 열(가로,row)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스의 개수 T 입력 받기
        int T = Integer.parseInt(br.readLine());

        // 2. 테스트 케이스의 수만큼 수행하기
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로의 길이 (1~50) -> C
            N = Integer.parseInt(st.nextToken()); // 세로의 길이 (1~50) -> R
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수 (반복 횟수)

            // 땅 초기화
            grid = new int[N][M];
            visited = new boolean[N][M];

            // K개의 배추 위치 입력 받기
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // M -> C (가로, 열)
                int Y = Integer.parseInt(st.nextToken()); // N -> R (세로, 행)
                grid[Y][X] = 1; // 배추의 위치 처리
            }

            // 탐색
            int count = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    // 방문하지 않았고, 배추 위치일 때
                    if (!visited[r][c] && grid[r][c] == 1) {
                        bfs(r, c);
                        count++;
                    }
                }
            }

            // 정답
            bw.write(count + "\n");
        }

        // 3. 최종 출력
        bw.flush();
    }

    static void bfs(int sr, int sc) {
        // 1. 초기 방문 처리
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        // 2. 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : DIR) {
                int nr = r + d[0];
                int nc = c + d[1];

                // 범위 체크
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] == 0) continue;

                // 방문 처리
                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}