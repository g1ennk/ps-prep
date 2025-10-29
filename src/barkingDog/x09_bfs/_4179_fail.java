package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 4179: 불
public class _4179_fail {

    static int R, C;
    static char[][] maze;
    static int[][] fireDist, jihunDist;
    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 행의 개수와 열의 개수 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 2. 초기화
        maze = new char[R][C];
        fireDist = new int[R][C];
        jihunDist = new int[R][C];

        // 3. 미로 정보 입력 받기 (지훈이의 초기위치와 불의 위치도 동시에 파악)
        ArrayDeque<int[]> jihunQ = new ArrayDeque<>();
        ArrayDeque<int[]> fireQ = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = line.charAt(j);
                fireDist[i][j] = -1;
                jihunDist[i][j] = -1;

                if (maze[i][j] == 'J') {
                    jihunQ.offer(new int[]{i, j});
                    jihunDist[i][j] = 0;
                }

                if (maze[i][j] == 'F') {
                    fireQ.offer(new int[]{i, j});
                    fireDist[i][j] = 0;
                }
            }
        }

        // 4. 불 BFS
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0];
            int y = cur[1];
            int curDist = fireDist[x][y];

            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                int newDist = curDist + 1;

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue; // 범위 체크
                if (maze[nx][ny] == '#' || fireDist[nx][ny] != -1) continue; // 벽 및 방문 여부 체크

                // 방문 처리
                fireQ.offer(new int[]{nx, ny});
                fireDist[nx][ny] = newDist;
            }
        }

        // 5. 지훈 BFS
        while (!jihunQ.isEmpty()) {
            int[] cur = jihunQ.poll();
            int x = cur[0];
            int y = cur[1];
            int curDist = jihunDist[x][y];

            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                int newDist = curDist + 1;

                // 범위를 벗어나면 탈출 -> 조기 반환
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    bw.write(newDist + "");
                    bw.flush();
                    return;
                }

                if (maze[nx][ny] == '#' || jihunDist[nx][ny] != -1) continue; // 벽 및 방문 여부 체크

                // 불보다 빨리 도착 가능한지 여부 확인
                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= newDist) continue;

                // 방문 처리
                jihunQ.offer(new int[]{nx, ny});
                jihunDist[nx][ny] = newDist;
            }
        }

        // 6. 조기 반환이 안되었다면 탈출 불가능
        bw.write("IMPOSSIBLE");
        bw.flush();
    }
}
