package barkingDog.x03_search_and_recursion.bfs.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {

    static final int PAINTED = 1;
    static final int[][] DIR4 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int pictureCount = 0;
    static int maxArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 세로 크기 n, 가로 크기 m 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // rows - y - 행
        m = Integer.parseInt(st.nextToken()); // cols - x - 열

        // 2. 초기화
        board = new int[n][m]; // y-n, x-m
        visited = new boolean[n][m];

        // 3. 그림 정보 입력
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. 탐색하면서 그림의 개수와 최대 넓이 구하기
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[y][x] == PAINTED && !visited[y][x]) {
                    pictureCount++;
                    maxArea = Math.max(maxArea, bfsArea(y, x));
                }
            }
        }

        // 5. 그림의 개수, 가장 넓은 그림의 넓이를 출력
        System.out.println(pictureCount + "\n" + maxArea);
    }

    // BFS로 그림의 넓이 구하기
    static int bfsArea(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 초기 방문 처리
        visited[y][x] = true;
        queue.offer(new int[]{y, x});
        int area = 1; // 시작점 포함

        // 탐색
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cy = curr[0];
            int cx = curr[1];

            // 4방향
            for (int[] d4 : DIR4) {
                int ny = cy + d4[0];
                int nx = cx + d4[1];

                // 체크
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (visited[ny][nx]) continue;
                if (board[ny][nx] != PAINTED) continue;

                // 방문처리
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
                area++;
            }
        }

        return area;
    }

}