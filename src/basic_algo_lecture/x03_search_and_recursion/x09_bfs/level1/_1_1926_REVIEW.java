package basic_algo_lecture.x03_search_and_recursion.x09_bfs.level1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 그림(TRY:2)
public class _1_1926_REVIEW {

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로의 크기 y 행
        int m = Integer.parseInt(st.nextToken()); // 가로의 크기 x 열

        // 2. 그림 정보 입력
        int[][] board = new int[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 풀이
        int[] answer = solution(board);

        // 4. 출력
        bw.write(answer[0] + "\n" + answer[1]);
        bw.flush();
    }

    public static int[] solution(int[][] board) {
        // 초기화
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        int totalDrawings = 0;
        int maxSize = 0;

        // 탐색 (그림의 개수를 카운트하고, 그림의 크기 구하기)
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                // 미방문이면서 그림인 경우에만
                if (!visited[y][x] && board[y][x] == 1) {
                    totalDrawings++;
                    maxSize = Math.max(maxSize, bfs(board, visited, y, x));
                }
            }
        }

        return new int[]{totalDrawings, maxSize};
    }

    private static int bfs(int[][] board, boolean[][] visited, int sy, int sx) {
        // 초기화
        int n = board.length, m = board[0].length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int size = 1;

        // 초기 방문 처리
        visited[sy][sx] = true;
        queue.offer(new int[]{sy, sx});

        // 탐색 (그림의 크기 구하기)
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int[] dir : DIRECTIONS) {
                int ny = cy + dir[0];
                int nx = cx + dir[1];

                // 범위 체크
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                // 이미 방문했거나, 그림이 아닌 칸(0)인 경우 스킵
                if (visited[ny][nx] || board[ny][nx] == 0) continue;

                // 방문 처리
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
                size++;
            }
        }

        return size;
    }
}

/* 메모
- 그림이 여러 개 존재하고, 그 중 넓이가 가장 큰 그림의 넓이를 구하는 문제
 */
