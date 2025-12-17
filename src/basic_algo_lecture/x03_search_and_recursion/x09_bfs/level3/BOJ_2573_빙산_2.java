package basic_algo_lecture.x03_search_and_recursion.x09_bfs.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2573_빙산_2 {

    static int N, M;
    static int[][] iceberg;
    static ArrayDeque<int[]> icebergPos = new ArrayDeque<>();
    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // Y
        M = Integer.parseInt(st.nextToken()); // X

        iceberg = new int[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                iceberg[y][x] = Integer.parseInt(st.nextToken());

                // 초기 빙산 위치 저장
                if (iceberg[y][x] > 0) icebergPos.offer(new int[]{y, x});
            }
        }

        System.out.println(solve());
    }

    static int solve() {
        int year = 0;

        while (true) {
            // 1. 빙산 덩어리 개수 세기
            int icebergCount = countIceBerg();

            //  2. 종료 조건 체크
            if (icebergCount > 1) return year;
            if (icebergCount == 0) return 0; // 분리 안되면 0 출력

            // 3. 빙산 녹이고, year 증가
            melt();
            year++;
        }
    }

    static void melt() {
        int[][] nextIceberg = new int[N][M];
        ArrayDeque<int[]> nextIcebergPos = new ArrayDeque<>();

        // 전체 순회가 아닌 빙산이 있는 위치만 녹이기
        int size = icebergPos.size();
        for (int i = 0; i < size; i++) {
            int[] cur = icebergPos.poll();
            int cy = cur[0], cx = cur[1];

            // 인접 바다
            int seaCount = 0;

            // 인접 방향 탐색
            for (int[] d : DIR) {
                int ny = cy + d[0], nx = cx + d[1];

                // 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                // 빙산이면 패스
                if (iceberg[ny][nx] > 0) continue;

                // 인접한 게 바다라면 카운트
                seaCount++;
            }

            // 빙산 녹이기
            nextIceberg[cy][cx] = Math.max(iceberg[cy][cx] - seaCount, 0);

            // 녹인 후 아직 빙산인 것만 다시 추가
            if (nextIceberg[cy][cx] > 0) nextIcebergPos.offer(new int[]{cy, cx});
        }

        // 해가 지날 때마다 빙산의 높이와 빙산의 위치 업데이트
        iceberg = nextIceberg;
        icebergPos = nextIcebergPos;
    }

    static int countIceBerg() {
        int count = 0;
        boolean[][] visited = new boolean[N][M];

        for (int[] pos : icebergPos) {
            int cy = pos[0], cx = pos[1];

            if (!visited[cy][cx] && iceberg[cy][cx] > 0) {
                bfs(cy, cx, visited);
                count++;

                // 조기 종료: 이미 2개 이상이면 더 이상 셀 필요 없음
                if (count > 1) return count;
            }
        }

        return count;
    }

    static void bfs(int y, int x, boolean[][] visited) {
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 초기 방문 처리
        visited[y][x] = true;
        q.offer(new int[]{y, x});

        // 탐색
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0], cx = cur[1];

            for (int[] d : DIR) {
                int ny = cy + d[0], nx = cx + d[1];

                // 범위 체크, 방문 여부 체크, 바다 여부 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (iceberg[ny][nx] == 0) continue;

                // 방문 처리
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
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