package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2178: 미로 탐색 (거리 측정)
public class _2178_1 {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 두 정수 N, M (세로, 가로)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // y
        int M = Integer.parseInt(st.nextToken()); // x

        // 2. 초기화
        char[][] maze = new char[N][M];
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1); // -1 = 미방문
        }

        // 3. 미로 정보 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        // 4. BFS
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // 초기 방문 처리
        dist[0][0] = 1;
        queue.offer(new int[]{0, 0});

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];
            int d = dist[y][x];

            // 종료 확인
            if (y == N - 1 && x == M - 1) {
                bw.write(String.valueOf(dist[y][x]));
                break;
            }

            // 4 방향 탐색
            for (int[] dir : DIR) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                int nd = d + 1;

                // 예외 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (dist[ny][nx] != -1) continue;
                if (maze[ny][nx] != '1') continue;

                // 방문체크
                dist[ny][nx] = nd;
                queue.offer(new int[]{ny, nx});
            }
        }

        // 5. 출력
        bw.flush();
    }

}
/*
- 1은 이동 가능, 0은 불가능
- 출발은 1,1에서 -> 0,0으로 대체
- N,M 타겟 위치까지 이동할 때 지나야 하는 최소 칸 수 -> 거리 문제
 */