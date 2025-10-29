package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 4179: 불
public class _4179_fail_2 {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C; // R = y, C = x
    static char[][] maze;
    static int[][] fireDist;
    static int[][] jihunDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. R과 C 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // y
        C = Integer.parseInt(st.nextToken()); // x

        // 2. 초기화
        maze = new char[R][C];
        fireDist = new int[R][C];
        jihunDist = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(fireDist[i], -1); // -1이 미방문
            Arrays.fill(jihunDist[i], -1);
        }

        // 2. 미로 정보 입력받기
        ArrayDeque<int[]> fq = new ArrayDeque<>(); // 불 위치 (여러 개 가능)
        ArrayDeque<int[]> jq = new ArrayDeque<>(); // 지훈 위치 (1개)
        for (int y = 0; y < R; y++) {
            String line = br.readLine();
            for (int x = 0; x < C; x++) {
                maze[y][x] = line.charAt(x);

                // 지훈 위치와 불 위치 큐에 삽입
                if (maze[y][x] == 'J') {
                    jq.offer(new int[]{y, x});
                    jihunDist[y][x] = 0;
                }
                if (maze[y][x] == 'F') {
                    fq.offer(new int[]{y, x});
                    fireDist[y][x] = 0;
                }
            }
        }

        // 3. 결과 출력
        bw.write(solution(fq, jq));
        bw.flush();
    }

    static String solution(ArrayDeque<int[]> fq, ArrayDeque<int[]> jq) {
        // 1. 불 먼저 확산
        while (!fq.isEmpty()) {
            int[] cur = fq.poll();
            int y = cur[0];
            int x = cur[1];

            // 네 방향 탐색
            for (int[] dir : DIR) {
                int ny = y + dir[0];
                int nx = x + dir[1];

                // 예외 처리
                if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                if (maze[ny][nx] == '#') continue;
                if (fireDist[ny][nx] != -1) continue;

                // 방문 처리
                fireDist[ny][nx] = fireDist[y][x] + 1;
                fq.offer(new int[]{ny, nx});
            }
        }

        // 2. 지훈 확산
        while (!jq.isEmpty()) {
            int[] cur = jq.poll();
            int y = cur[0];
            int x = cur[1];
            int d = jihunDist[y][x];

            // 종료 조건
            if (y == 0 || y == R - 1 || x == 0 || x == C - 1) {
                return String.valueOf(jihunDist[y][x] + 1);
            }

            for (int[] dir : DIR) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                int nd = d + 1;

                // 예외처리
                if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                if (maze[ny][nx] == '#') continue;
                if (jihunDist[ny][nx] != -1) continue;

                // 불과 비교 (불이 올 예정이고, 불이 지훈보다 먼저 또는 동시에 오는 칸은 못 간다)
                if (fireDist[ny][nx] != -1 && nd >= fireDist[ny][nx]) continue;

                // 방문 처리
                jihunDist[ny][nx] = nd;
                jq.offer(new int[]{ny, nx});
            }
        }

        return "IMPOSSIBLE";
    }
}
