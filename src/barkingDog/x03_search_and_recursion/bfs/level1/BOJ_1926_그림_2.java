package barkingDog.x03_search_and_recursion.bfs.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1926_그림_2 {

    static final int PAINT = 1;
    static final int[][] DIR4 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int n, m; // y,x
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        int count = 0, maxSize = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[y][x] == PAINT && !visited[y][x]) {
                    count++;
                    maxSize = Math.max(maxSize, bfs(y, x));
                }
            }
        }

        System.out.println(count + "\n" + maxSize);
    }

    static int bfs(int sy, int sx) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int size = 1;

        queue.offer(new int[]{sy, sx});
        visited[sy][sx] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1];

            for (int[] d : DIR4) {
                int ny = cy + d[0], nx = cx + d[1];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (board[ny][nx] != PAINT) continue;
                if (visited[ny][nx]) continue;

                queue.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
                size++;
            }
        }

        return size;
    }

}
