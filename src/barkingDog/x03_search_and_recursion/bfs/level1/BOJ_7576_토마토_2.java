package barkingDog.x03_search_and_recursion.bfs.level1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_7576_토마토_2 {

    static final int[][] DIR4 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int RIPE = 1;
    static final int UNRIPE = 0;

    static int M, N; // X,Y
    static int[][] box;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. M과 N 입력받기 (X,Y)
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 2. 초기화
        box = new int[N][M];

        // 3. 토마토 정보 입력받기
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                box[y][x] = Integer.parseInt(st.nextToken());

                // 익은 토마토는 큐에 넣기
                if (box[y][x] == RIPE) {
                    queue.offer(new int[]{y, x});
                }
            }
        }

        // 4. 결과 출력하기
        bw.write(String.valueOf(solve()));
        bw.flush();
    }

    static int solve() {
        int max = RIPE;

        while (!queue.isEmpty()) {
            // 익은 토마토
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1];

            // 4방향 탐색
            for (int[] d : DIR4) {
                int ny = cy + d[0], nx = cx + d[1];

                // 예외 처리
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (box[ny][nx] != UNRIPE) continue;

                // 방문 처리
                box[ny][nx] = box[cy][cx] + 1;
                queue.offer(new int[]{ny, nx});

                // 최대 거리 갱신
                max = Math.max(max, box[ny][nx]);
            }
        }

        // 아직 안 익은 게 있는지 확인 후 안 익은 게 있다면 -1 반환
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (box[y][x] == UNRIPE) return -1;
            }
        }

        // max 초기 값이 1부터 시작하므로
        return max - 1;
    }
}