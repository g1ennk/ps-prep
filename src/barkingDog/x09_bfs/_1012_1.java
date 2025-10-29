package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1012: 유기농 배추
public class _1012_1 {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] ground;
    static boolean[][] visited;
    static int R, C; // 세로, 가로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스의 개수 T 입력 받기
        int T = Integer.parseInt(br.readLine());

        // 2. 테스트 케이스 수행
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken()); // 가로 -> 열
            R = Integer.parseInt(st.nextToken()); // 세로 -> 행
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수 (반복 횟수)

            ground = new int[R][C];
            visited = new boolean[R][C];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 가로
                int Y = Integer.parseInt(st.nextToken()); // 세로
                ground[Y][X] = 1;
            }

            int count = 0;
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (ground[r][c] == 1 && !visited[r][c]) {
                        bfs(r, c);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }

        // 3. 결과 출력
        bw.flush();
    }

    static void bfs(int r, int c) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int[] d : DIR) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (visited[nx][ny]) continue;
                if (ground[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }

}