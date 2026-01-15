package barkingDog.x03_search_and_recursion.bfs.level1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1926_그림_3 {

    static final int PAINT = 1;
    static final int[][] DIR4 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int n; // 세로, y
    static int m; // 가로, x
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(solution());
        bw.flush();
    }

    static String solution() {
        int count = 0;
        int maxSize = 0; // 그림이 하나도 없는 경우 가장 넓은 그림의 넓이는 0

        // 전체 탐색
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                // 입력과 동시에 그림 확인
                if (board[y][x] == PAINT && !visited[y][x]) {
                    maxSize = Math.max(maxSize, bfs(y, x));
                    count++;
                }
            }
        }

        return count + "\n" + maxSize;
    }

    static int bfs(int sy, int sx) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int size = 1;

        // 초기 방문 처리
        visited[sy][sx] = true;
        q.offer(new int[]{sy, sx});

        // 탐색
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            // 4방향
            for (int[] d : DIR4) {
                int ny = cy + d[0];
                int nx = cx + d[1];

                // 예외 처리
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (visited[ny][nx]) continue;
                if (board[ny][nx] != PAINT) continue;

                // 방문 처리
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
                size++;
            }
        }

        return size;
    }

}