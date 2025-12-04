package basic_algo_lecture.x03_search_and_recursion.x09_bfs.practice;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 유기농 배추 (TRY:2)
public class _6_1012_REVIEW {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int M, N; // X,Y
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            // 2. 가로 M, 세로 N, 배추 위치 개수 K
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 (X)
            N = Integer.parseInt(st.nextToken()); // 세로 (Y)
            int K = Integer.parseInt(st.nextToken());

            // 3. 배추밭 초기화
            board = new int[N][M];
            visited = new boolean[N][M];

            // 4. 배추의 위치 입력 (X,Y)
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                board[Y][X] = 1;
            }

            // 5. BFS로 지렁이 세기
            int count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (board[y][x] == 1 && !visited[y][x]) {
                        bfs(y, x);
                        count++;
                    }
                }
            }

            // 6. 결과 출력
            bw.write(count + "\n");
        }

        // 7. 최종 출력
        bw.flush();
    }

    static void bfs(int sy, int sx) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 시작점 방문 처리
        visited[sy][sx] = true;
        queue.offer(new int[]{sy, sx});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1];

            for (int[] d : DIR) {
                int ny = cy + d[0];
                int nx = cx + d[1];

                // 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                // 방문 여부 체크
                if (visited[ny][nx]) continue;
                // 배추가 심어져 있는지 체크
                if (board[ny][nx] != 1) continue;

                // 방문 처리 및 큐 삽입
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
            }
        }
    }

}

/* 문제
- 지렁이가 인접한 해충을 잡아 먹어 배추를 보호한다.
- 상하좌우 인접
- 0은 배추가 심어져 있지 않은 땅, 1은 배추가 심어져 있는 땅
- 총 몇 마리의 지렁이가 필요한가?
 */

/* 입력과 출력
- 테스트 케이스 T
- 가로 M, 세로 N, 배추가 심어져 있는 위치의 개수 K
 */

/* 메모
- 방향 뿐만 아니라 크기, 정보까지 static으로 처리해서 푸는 게 더 쉽다.
- 무작정 코드로 들어가지 말고 충분히 설계에 신경써서 코드 들어가기
 */
