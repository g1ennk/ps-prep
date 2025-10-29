package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 7569: 토마토 (시작점이 여러 개이기 때문에 큐에 미리 담고 시작)
public class _7569_1 {

    static final int[][] DIR = {
            {-1, 0, 0},
            {1, 0, 0},
            {0, -1, 0},
            {0, 1, 0},
            {0, 0, -1},
            {0, 0, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. M, N, H 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // x
        int N = Integer.parseInt(st.nextToken()); // y
        int H = Integer.parseInt(st.nextToken()); // z

        // 2. 초기화
        int[][][] container = new int[H][N][M];
        int[][][] dist = new int[H][N][M]; // 0으로 초기화
        ArrayDeque<int[]> q = new ArrayDeque<>(); // z,y,x 넣기

        // 3. 토마토 정보 입력받기
        boolean allRipe = true;
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    int status = Integer.parseInt(st.nextToken());
                    container[z][y][x] = status;

                    // 조기 종료 조건 체크
                    if (status == 0) allRipe = false;

                    // 익은 토마토 위치 큐에 삽입
                    if (status == 1) {
                        q.offer(new int[]{z, y, x});
                        dist[z][y][x] = 0; // 0부터 시작
                    }
                    if (status == 0) dist[z][y][x] = -1; // 익지 않은 토마토 미방문 처리
                    if (status == -1) dist[z][y][x] = 0; // 들어있지 않은 곳은 방문 처리
                }
            }
        }

        // 4. 조기 종료 결과 출력
        if (allRipe) {
            bw.write("0");
            bw.flush();
            return;
        }

        // 5. BFS로 거리 측정
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];
            int d = dist[z][y][x];

            for (int[] dir : DIR) {
                int nz = z + dir[0];
                int ny = y + dir[1];
                int nx = x + dir[2];
                int nd = d + 1;

                // 예외 처리
                if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (dist[nz][ny][nx] != -1) continue;

                // 방문 처리
                dist[nz][ny][nx] = nd;
                q.offer(new int[]{nz, ny, nx});
            }
        }

        // 6. 전체 탐색 (최소 일수 구하거나 익지 않은 토마토 확인)
        int maxDist = 0;
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    int d = dist[z][y][x];

                    // 최소 일수 갱신
                    maxDist = Math.max(maxDist, d);

                    // 익지 않은 토마토 확인
                    if (d == -1) {
                        bw.write("-1");
                        bw.flush();
                        return;
                    }
                }
            }
        }

        // 7. 최소 일수 출력
        bw.write(String.valueOf(maxDist));
        bw.flush();
    }

}

/*
- 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
- 모든 토마토가 며칠이 지나야 다 익는지 -> 거리 문제
- 토마토가 익거나, 안 익거나, 들어있지 않거나

- M-x, N-y, H-z
- 토마토 정보
- 1 = 익은 토마토, 0 = 익지 않은 토마토, -1 = 토마토가 들어있지 않음

- 만약 이미 저장될 때부터 익어 있는 상태 -> 0
- 익지 못하는 상황 -> -1
- 다 익으면 -> 최소 일수
 */