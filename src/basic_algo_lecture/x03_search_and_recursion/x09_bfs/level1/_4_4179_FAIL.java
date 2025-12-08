package basic_algo_lecture.x03_search_and_recursion.x09_bfs.level1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 불!(TRY:2)
public class _4_4179_FAIL {

    // 상하좌우
    static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 가로
        int C = Integer.parseInt(st.nextToken()); // 세로

        // 초기화 및 입력
        char[][] board = new char[R][C];
        int[][] jihunDist = new int[R][C];
        int[][] fireDist = new int[R][C];
        ArrayDeque<int[]> jihunQueue = new ArrayDeque<>();
        ArrayDeque<int[]> fireQueue = new ArrayDeque<>();

        for (int y = 0; y < R; y++) {
            Arrays.fill(jihunDist[y], -1);
            Arrays.fill(fireDist[y], -1);
            String line = br.readLine();
            for (int x = 0; x < C; x++) {
                board[y][x] = line.charAt(x);

                // 지훈 초기 위치
                if (board[y][x] == 'J') {
                    jihunQueue.offer(new int[]{y, x});
                    jihunDist[y][x] = 0;
                }

                // 불 초기 위치
                if (board[y][x] == 'F') {
                    fireQueue.offer(new int[]{y, x});
                    fireDist[y][x] = 0;
                }
            }
        }

        // 풀이
        String answer = solution(R, C, board, jihunQueue, jihunDist, fireQueue, fireDist);

        // 출력
        bw.write(answer);
        bw.flush();
    }

    static String solution(int R, int C, char[][] board, ArrayDeque<int[]> jihunQueue, int[][] jihunDist, ArrayDeque<int[]> fireQueue, int[][] fireDist) {
        // 불 먼저 확산
        while (!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int cy = cur[0], cx = cur[1], cd = fireDist[cy][cx];

            // 4방향
            for (int[] dir : DIR) {
                int ny = cy + dir[0], nx = cx + dir[1], nd = cd + 1;

                // 범위 체크
                if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                // 벽 체크
                if (board[ny][nx] == '#') continue;
                // 방문 여부 체크
                if (fireDist[ny][nx] != -1) continue;

                // 방문 처리
                fireDist[ny][nx] = nd;
                fireQueue.offer(new int[]{ny, nx});
            }
        }

        // 지훈 확산
        while (!jihunQueue.isEmpty()) {
            int[] cur = jihunQueue.poll();
            int cy = cur[0], cx = cur[1], cd = jihunDist[cy][cx];

            // 탈출 여부 체크
            if (cy == 0 || cy == R - 1 || cx == 0 || cx == C - 1) {
                return String.valueOf(cd + 1);
            }

            // 4방향 탐색
            for (int[] dir : DIR) {
                int ny = cy + dir[0], nx = cx + dir[1], nd = cd + 1;

                // 범위 체크
                if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                // 벽 체크
                if (board[ny][nx] == '#') continue;
                // 방문 여부 체크
                if (jihunDist[ny][nx] != -1) continue;
                // 불보다 빠른지 여부 체크
                if (nd >= fireDist[ny][nx]) continue;

                // 방문 처리
                jihunDist[ny][nx] = nd;
                jihunQueue.offer(new int[]{ny, nx});

            }
        }

        // 조기 반환 X = 탈출 불가능
        return "IMPOSSIBLE";
    }


}

/* 메모
- 문제
    - 지훈이가 탈출 가능한지, 가능하다면 얼마나 빨리 탈출할 수 있는지
    - 지훈이와 불은 매 분마다 이동 (4방향)
    - 지훈이가 가장 자리 도달 시 탈출 가능
    - 지훈이는 불 혹은 벽이 있는 공간은 탈출하지 못함

- 입력
    - R = 행, C = 열 -> R = Y, C = X
    - # = 벽, . = 지나갈 수 있는 공간, J = 지훈 초기 위치, F = 불

- 출력
    - 탈출할 수 없는 경우 -> IMPOSSIBLE 출력, 가능하다면 가장 빠른 탈출 시간 = 거리

- 풀이
    - 지훈이가 이동하는 속도가 불이 이동하는 속도보다 작아야 지훈이가 이동 가능하다고 판단 -> 지훈 거리 배열과 불 거리 배열이 둘 다 필요
    - 지훈 위치 거리를 1로, 지나갈 수 있는 공간을 0으로 초기화
    - 불 먼저 확산 후 지훈이 거리 < 불 거리 -> 거리 계산 및 방문 처리
    - 지훈이가 이동 못하는 곳은 거리 -1로 처리 = 이동 불가능한 곳
    - 지훈이가 가장 자리 도달 시 탈출, 만약 조기 반환이 불가능하면 IMPOSSIBLE 반환
 */

/*
4 4
####
#JF#
#..#
#..#

지훈
-1 -1 -1 -1
-1  1 -1 -1
-1  2 -1 -1
-1  3 -1 -1

불
-1 -1 -1 -1
-1  2  1 -1
-1  3  2 -1
-1  4  3 -1
 */