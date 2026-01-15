package barkingDog.x03_search_and_recursion.bfs.level1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 토마토(TRY:2)
public class BOJ_7576_토마토_1 {

    // 상하좌우
    static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        // 초기화
        int[][] board = new int[N][M];
        int[][] dist = new int[N][M];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean isAllRipens = true;

        for (int y = 0; y < N; y++) {
            Arrays.fill(dist[y], -1);
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());

                // 익은 토마토 체크
                if (board[y][x] == 1) {
                    queue.offer(new int[]{y, x});
                    dist[y][x] = 0;
                }

                // 모두 익어있는 상태 체크
                if (board[y][x] == 0) {
                    isAllRipens = false;
                }
            }
        }

        // 모두 익어있는 경우 0 출력
        if (isAllRipens) {
            bw.write("0");
            bw.flush();
            return;
        }

        // 풀이
        int answer = solution(M, N, board, queue, dist);

        // 출력
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    public static int solution(int M, int N, int[][] board, ArrayDeque<int[]> queue, int[][] dist) {
        int max = 0;

        // 탐색
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1], cd = dist[cy][cx];

            for (int[] dir : DIR) {
                int ny = cy + dir[0], nx = cx + dir[1], nd = cd + 1;

                // 범위체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                // 토마토가 없는 칸 체크
                if (board[ny][nx] == -1) continue;
                // 방문 여부 체크
                if (dist[ny][nx] != -1) continue;

                // 방문 처리
                dist[ny][nx] = nd;
                queue.offer(new int[]{ny, nx});
                max = Math.max(max, nd);
            }
        }

        // 익지 못하는 상황 체크
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                // 토마토가 있는데 미방문한 경우 = 익지 못하는 상황
                if (board[y][x] == 0 && dist[y][x] == -1) {
                    return -1;
                }
            }
        }

        // 최소 일수 반환
        return max;
    }

}

/* 메모
- 보관된 토마토들이 며칠이 지나면 다 이게 되는지, 그 최소 일수 -> 거리 문제
- M(가로), N(세로)
- 1 = 익은 토마토, 0 = 익지 않은 토마토, -1 = 토마토가 들어있지 않은 칸

- 입력부터 모두 토마토가 익은 상태 -> 0 출력
- 토마토가 모두 익지 못하는 상황 -> -1 출력
- 둘 다 아니라면 최소 날짜 출력

- 시작 지점이 여러 개일 수 있기 때문에 애초에 Queue로 전달
 */

/* 실수
- 범위 체크 시 짝 주의
- 조건이 많은 만큼 문제 자세히 읽어야 함
 */
