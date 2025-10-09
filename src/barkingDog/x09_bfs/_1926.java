package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1926: 그림
public class _1926 {

    static int[][] board;
    static boolean[][] visited;
    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 세로 크기 n과 가로 크기 m 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2. 2차원 배열 초기화
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 결과 출력
        bw.write(solution());
        bw.flush();
    }

    static String solution() {
        // 그림의 개수와 최대 넓이 초기화
        int totalDrawing = 0;
        int maxSize = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                // 그림이고(1), 방문하지 않은 경우에만 bfs 시작
                if (board[r][c] == 1 && !visited[r][c]) {
                    totalDrawing++;
                    int size = bfs(r, c); // 탐색 시작 및 넓이 구하기
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return totalDrawing + "\n" + maxSize;
    }

    static int bfs(int startX, int startY) {
        // 1. 초기화
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[startX][startY] = true; // 초기 위치 방문 처리
        queue.offer(new int[]{startX, startY}); // 초기 위치 큐 삽입

        int size = 1; // 현재 그림의 크기

        // 2. 탐색 및 사이즈 구하기
        while (!queue.isEmpty()) {
            // 큐 뽑기
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 상하좌우 탐색
            for (int[] direction : DIRECTIONS) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];

                // 범위를 벗어나거나, 그림이 아니거나, 이미 방문했다면 continue
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (board[nextX][nextY] != 1) continue;
                if (visited[nextX][nextY]) continue;

                // 방문 처리 및 큐 삽입
                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY});
                size++;
            }
        }

        return size;
    }
}