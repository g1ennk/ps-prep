package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 5427: 불
public class _5427_불 {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스의 개수 T 입력받기
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // 2. 너비 w와 높이 h 입력받기 w = x, h = y
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 너비 x
            int h = Integer.parseInt(st.nextToken()); // 높이 y

            // 3. 초기화
            char[][] building = new char[h][w];
            ArrayDeque<int[]> fireQueue = new ArrayDeque<>();
            ArrayDeque<int[]> escapeQueue = new ArrayDeque<>();
            int[][] fireDist = new int[h][w];
            int[][] escapeDist = new int[h][w];
            for (int i = 0; i < h; i++) {
                Arrays.fill(fireDist[i], -1);
                Arrays.fill(escapeDist[i], -1);
            }
            StringBuilder sb = new StringBuilder();

            // 4. 빌딩 정보 입력 받기
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    building[i][j] = line.charAt(j);
                    if (building[i][j] == '*') {
                        fireQueue.offer(new int[]{i, j});
                        fireDist[i][j] = 0;
                    }
                    if (building[i][j] == '@') {
                        escapeQueue.offer(new int[]{i, j});
                        escapeDist[i][j] = 0;
                    }
                }
            }

            // 5. 불 BFS
            while (!fireQueue.isEmpty()) {
                int[] cur = fireQueue.poll();
                int y = cur[0];
                int x = cur[1];
                int dist = fireDist[y][x];

                // 동서남북 체크
                for (int[] dir : DIR) {
                    int ny = y + dir[0];
                    int nx = x + dir[1];
                    int newDist = dist + 1;

                    // 예외 체크
                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                    if (fireDist[ny][nx] != -1) continue;
                    if (building[ny][nx] == '#') continue;

                    // 방문 처리
                    fireDist[ny][nx] = newDist;
                    fireQueue.offer(new int[]{ny, nx});
                }
            }

            // 6. 상근 BFS
            boolean escaped = false;
            while (!escapeQueue.isEmpty()) {
                int[] cur = escapeQueue.poll();
                int y = cur[0];
                int x = cur[1];
                int dist = escapeDist[y][x];

                // 동서남북 체크
                for (int[] dir : DIR) {
                    int ny = y + dir[0];
                    int nx = x + dir[1];
                    int newDist = dist + 1;

                    // 탈출 처리
                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                        bw.write(newDist +"\n");
                        escaped = true;
                        escapeQueue.clear();
                        break;
                    }

                    // 예외 처리
                    if (escapeDist[ny][nx] != -1) continue;
                    if (building[ny][nx] == '*' || building[ny][nx] == '#') continue;

                    // 불 시간 비교
                    if (fireDist[ny][nx] != -1 && fireDist[ny][nx] <= newDist) continue;

                    // 방문 처리
                    escapeDist[ny][nx] = newDist;
                    escapeQueue.offer(new int[]{ny, nx});
                }

                if (escaped) break;
            }

            // 최종 판별
            if (!escaped) bw.write("IMPOSSIBLE\n");
        }

        // 5. 최종 결과 출력하기
        bw.flush();
    }
}