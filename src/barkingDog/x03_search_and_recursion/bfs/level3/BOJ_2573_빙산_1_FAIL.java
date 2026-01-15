package barkingDog.x03_search_and_recursion.bfs.level3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2573_빙산_1_FAIL {

    static int N, M;
    static int[][] iceberg;
    static int time = 0;

    static final int[][] DIR = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 행과 열의 개수 N과 M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // Y
        M = Integer.parseInt(st.nextToken()); // X

        // 2. 빙산의 정보 입력
        iceberg = new int[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                iceberg[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 결과 출력
        solution2();
        bw.write(String.valueOf(time));
        bw.flush();
    }

    public static void solution2() {
        while (true) {
            int iceBergCount = countIceberg(); // 현재 빙산 덩어리 개수

            // 분리가 되지 않으면 0 출력
            if (iceBergCount == 0) {
                time = 0;
                return;
            }

            // 두 덩어리 이상으로 분리된 시점
            if (iceBergCount > 1) {
                return;
            }

            // 아직도 한 덩어리면 1년 더 녹이기
            melt();
            time++;
        }
    }

    private static void melt() {
        int[][] nextIceberg = new int[N][M];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {

                // 바다는 패스
                if (iceberg[y][x] == 0) continue;

                // 인접한 바다의 개수
                int sea = 0;
                for (int[] d : DIR) {
                    int ny = y + d[0], nx = x + d[1];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if (iceberg[ny][nx] == 0) sea++;
                }

                // 다음 해 높이 = 현재 높이 - 인접 바다 수 (최소 0)
                nextIceberg[y][x] = Math.max(iceberg[y][x] - sea, 0);
            }
        }

        // 아이스버그 교체
        iceberg = nextIceberg;
    }

    private static int countIceberg() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                // 아직 빙산이고, 방문 안 했으면 새로운 덩어리 시작
                if (iceberg[y][x] != 0 && !visited[y][x]) {
                    count++;

                    // 2개 이상이면 더 셀 필요도 없음
                    if (count > 1) return count;

                    visited[y][x] = true;
                    queue.offer(new int[]{y, x});

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int cy = cur[0], cx = cur[1];

                        for (int[] d : DIR) {
                            int ny = cy + d[0], nx = cx + d[1];

                            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                            if (visited[ny][nx]) continue;
                            if (iceberg[ny][nx] == 0) continue;

                            visited[ny][nx] = true;
                            queue.offer(new int[]{ny, nx});
                        }
                    }
                }
            }
        }

        return count;
    }
}

/* 메모
- 2차원 배열
- 높이 정보가 배열의 각 칸에 양의 정수로 저장
- 빙산이 아닌 바다는 0은 채워져 있다.
- 빙산의 높이는 바닷물에 많이 접해져 있는 부분에서 빨리 줄어든다.
    - 일년마다 그 칸에 동서남북 네 방향으로 붙어있는 0이 저장된 칸의 갯수만큼 줄어든다.
    - 0이 최저 높이로 그 이하는 줄어들지 않는다.
- 한 덩어리의 빙산이 주어질 때 이 빙상이 두 덩어리 이상으로 분리되는 최초의 시간을 구하는 프로그램을 작성하라
- 만약 빙산이 다 녹을 때까지 두 덩어리 이상 분리되지 않으면 0을 출력한다.

- 종료 조건이 두 덩어리 이상 분리될 때까지인데 이걸 어떻게 판달할까?
- 하나를 카피해놓고 한 바퀴 돌면 갱신
- 그림의 개수 카운트 하듯이 한 번 더 bfs를 돌면서 개수가 1개 이상이면 종료 조건으로

5 7

[original]
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0

[time = 1]
0 0 0 0 0 0 0
0 0 3 4 1 0 0
0 2 0 1 5 0 0
0 5 4 1 2 0 0
0 0 0 0 0 0 0

[time = 2]
0 0 0 0 0 0 0
0 0 0 3 0 0 0
0 0 0 0 4 0 0
0 3 2 0 0 0 0
0 0 0 0 0 0 0

*/