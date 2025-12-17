package basic_algo_lecture.x03_search_and_recursion.x09_bfs.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2573_빙산_3 {

    static int N, M;
    static int[][] icebergs;
    static ArrayDeque<int[]> icebergPositions = new ArrayDeque<>();

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        icebergs = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                icebergs[i][j] = Integer.parseInt(st.nextToken());

                // 초기 빙산 위치 저장
                if (icebergs[i][j] > 0) icebergPositions.offer(new int[]{i, j});
            }
        }

        System.out.println(solution());
    }

    static int solution() {
        int year = 0;

        while (true) {
            // 빙산의 개수 세기
            int icebergCount = countIcebergs();

            // 종료 조건 1: 분리되는 순간 바로 year 반환
            if (icebergCount >= 2) return year;

            // 종료 조건 2: 다 녹았으면 0 반환
            if (icebergCount == 0) return 0;

            // 1년 녹이기
            melt();
            year++;
        }
    }

    static void melt() {
        int[][] nextIcebergs = new int[N][M];
        ArrayDeque<int[]> nextIcebergPositions = new ArrayDeque<>();

        while (!icebergPositions.isEmpty()) {
            int[] pos = icebergPositions.poll();
            int y = pos[0], x = pos[1];
            int seaCount = 0;

            for (int[] d : DIR) {
                int ny = y + d[0], nx = x + d[1];

                // 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                // 인접한 바다 개수 세기
                if (icebergs[ny][nx] == 0) seaCount++;
            }

            // 빙산 높이 업데이트
            int newHeight = Math.max(icebergs[y][x] - seaCount, 0);
            nextIcebergs[y][x] = newHeight;

            // 아직 높이가 0이 아니라면 위치 저장
            if (newHeight > 0) {
                nextIcebergPositions.offer(new int[]{y, x});
            }
        }

        // 최종 업데이트
        icebergs = nextIcebergs;
        icebergPositions = nextIcebergPositions;
    }

    static int countIcebergs() {
        int count = 0;
        boolean[][] visited = new boolean[N][M];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (!visited[y][x] && icebergs[y][x] > 0) {
                    bfs(visited, y, x);
                    count++;
                }
            }
        }

        return count;
    }

    static void bfs(boolean[][] visited, int sy, int sx) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 초기 방문 처리
        visited[sy][sx] = true;
        queue.offer(new int[]{sy, sx});

        // 탐색
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cy = pos[0], cx = pos[1];

            for (int[] d : DIR) {
                int ny = cy + d[0], nx = cx + d[1];

                // 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                // 방문 체크
                if (visited[ny][nx]) continue;
                // 바다 체크
                if (icebergs[ny][nx] == 0) continue;

                // 방문 처리
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
            }
        }

    }

}

/* 메모
1. 문제 이해
- 2차원 배열, 배열의 높이 정보가 양의 정수로 저장, 빙산 이외 바다는 0으로 저장
- 인접해 있는 바다의 개수만큼 높이가 줄어듬, 0이 최소
- 한 덩어리 빙산이 주어지고, 두 덩어리 이상으로 분리되는 최초의 시간을 구해라, 다 녹았는데 두 덩어리 이상 분리되지 않으면 0 출력

[time = 0]
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
-> 덩어리 개수 = 1

[time = 1]
0 0 0 0 0 0 0
0 0 2 4 1 0 0
0 1 0 1 5 0 0
0 5 4 1 2 0 0
0 0 0 0 0 0 0
-> 덩어리 개수 = 1

[time = 2]
0 0 0 0 0 0 0
0 0 0 3 0 0 0
0 0 0 0 4 0 0
0 3 2 0 0 0 0
0 0 0 0 0 0 0
-> 덩어리 개수 = 3
-> 종료
 */