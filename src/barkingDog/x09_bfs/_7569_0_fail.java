package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 7569: 토마토 (시작점이 여러 개이기 때문에 큐에 미리 담고 시작)
public class _7569_0_fail {

    static int H, M, N; // 높이, 가로, 세로 -> z, y, z
    static int[][][] box;
    static int[][][] dist;
    static final int[][] DIR = {
            {0, -1, 0}, // 상
            {0, 1, 0}, // 하
            {0, 0, -1}, // 좌
            {0, 0, 1}, // 우
            {1, 0, 0}, // 위
            {-1, 0, 0} // 아래
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. M 가로, N 세로, H 높이
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 M -> x
        N = Integer.parseInt(st.nextToken()); // 세로 N -> y
        H = Integer.parseInt(st.nextToken()); // 높이 H -> z

        // 2. 초기화
        ArrayDeque<int[]> q = new ArrayDeque<>(); // 여러 개의 시작점
        box = new int[H][N][M];
        dist = new int[H][N][M];

        // 3. 정보 입력 받기 (처음부터 모두 익어있는 상태 체크)
        boolean isAllRipped = true; // 하나로도 안 익은 게 나오면 false
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    int value = Integer.parseInt(st.nextToken());
                    box[z][y][x] = value;

                    // 익어있는 상태 체크
                    if (value == 0) isAllRipped = false;

                    switch (value) {
                        // 익은 토마토: 시작지점은 큐에 넣고, 거리는 0
                        case 1:
                            q.offer(new int[]{z, y, x});
                            dist[z][y][x] = 0;
                            break;
                        // 익지 않은 토마토: 방문 전으로 미방문 처리로 -1
                        case 0:
                            dist[z][y][x] = -1;
                            break;
                        // 토마토가 들어 있지 않음: 방문 처리하여 0
                        case -1:
                            dist[z][y][x] = 0;
                            break;
                    }
                }
            }
        }

        // 조기 반환 체크 (전체를 돌았는데 안 익은 게 없다면 조기 반환)
        if (isAllRipped) {
            bw.write("0");
            bw.flush();
            return;
        }

        // 4. 결과 출력하기
        bw.write(String.valueOf(bfs(q)));
        bw.flush();
    }

    static int bfs(ArrayDeque<int[]> q) {
        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cz = cur[0];
            int cy = cur[1];
            int cx = cur[2];
            int cd = dist[cz][cy][cx];

            // 6개 방향 탐색
            for (int[] dir : DIR) {
                int nz = cz + dir[0];
                int ny = cy + dir[1];
                int nx = cx + dir[2];

                // 체크
                if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (box[nz][ny][nx] != 0) continue; // 익거나 빈칸이거나 (즉, 익을 수 있는 것만 남김)
                if (dist[nz][ny][nx] != -1) continue; // 방문 여부 (0은 방문 or 없음, -1은 비방문)

                // 방문 처리
                dist[nz][ny][nx] = cd + 1;
                q.offer(new int[]{nz, ny, nx});
            }
        }

        // 최소 일수 알아내기 (최소 일수 or 익지 못하는 상황)
        int maxDist = 0;
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    // -1이 나왔다는 것 미방문한 즉, 익지 못한 게 나왔다? -> 방문이 불가능하다 -> -1
                    if (dist[z][y][x] == -1) return -1;
                    maxDist = Math.max(maxDist, dist[z][y][x]);
                }
            }
        }

        return maxDist;
    }

}