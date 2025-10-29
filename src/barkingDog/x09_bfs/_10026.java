package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;

// 10026: 적록색약
public class _10026 {

    static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N 입력받기
        N = Integer.parseInt(br.readLine());

        // 2. 구역 입력받기
        char[][] normal = new char[N][N];
        char[][] abnormal = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char color = line.charAt(j);
                normal[i][j] = color;
                abnormal[i][j] = color;
                if (color == 'G') abnormal[i][j] = 'R';
            }
        }

        // 3. 탐색하기
        int normalCount = 0;
        int abnormalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 정상 먼저 탐색
                if (normal[i][j] != 'V') {
                    normal = bfs(i, j, normal[i][j], normal);
                    normalCount++;
                }

                // 적록색약 탐색
                if (abnormal[i][j] != 'V') {
                    abnormal = bfs(i, j, abnormal[i][j], abnormal);
                    abnormalCount++;
                }
            }
        }

        // 4. 출력하기
        bw.write(normalCount + " " + abnormalCount);
        bw.flush();
    }

    static char[][] bfs(int i, int j, char c, char[][] area) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        area[i][j] = 'V';

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int[] dir : DIR) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (area[nx][ny] != c) continue;
                if (area[nx][ny] == 'V') continue;

                q.offer(new int[]{nx, ny});
                area[nx][ny] = 'V';
            }
        }

        return area;
    }
}