package basic_algo_lecture.x03_search_and_recursion.x09_bfs.level2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 불 (TRY:2)
public class _10_5427_REVIEW {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final char WALL = '#';
    static final char S = '@';
    static final char FIRE = '*';

    static int W, H;
    static char[][] building;
    static int[][] fireDist;
    static int[][] sDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 T 입력
        int T = Integer.parseInt(br.readLine());

        // 2. 테스트 케이스 실행
        for (int i = 0; i < T; i++) {
            // 2.1. 너비 w와 높이 h 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            // 2.2. 초기화
            building = new char[H][W];
            fireDist = new int[H][W];
            sDist = new int[H][W];
            for (int y = 0; y < H; y++) {
                Arrays.fill(fireDist[y], -1);
                Arrays.fill(sDist[y], -1);
            }

            // 2.3. 빌딩의 정보 입력
            ArrayDeque<int[]> fireQ = new ArrayDeque<>();
            ArrayDeque<int[]> sQ = new ArrayDeque<>();

            for (int y = 0; y < H; y++) {
                String line = br.readLine();
                for (int x = 0; x < W; x++) {
                    char c = line.charAt(x);
                    building[y][x] = c;

                    // 상근이 초기 방문 처리
                    if (c == S) {
                        sDist[y][x] = 0;
                        sQ.offer(new int[]{y, x});
                    }

                    // 불 초기 방문 처리
                    if (c == FIRE) {
                        fireDist[y][x] = 0;
                        fireQ.offer(new int[]{y, x});
                    }
                }
            }

            // 2.4. BFS
            bw.write(solution(fireQ, sQ) + "\n");
        }

        // 3. 최종 출력
        bw.flush();
    }

    static String solution(ArrayDeque<int[]> fireQ, ArrayDeque<int[]> sQ) {
        // 불 탐색
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int cy = cur[0], cx = cur[1];
            int cd = fireDist[cy][cx];

            // 4방향
            for (int[] d : DIR) {
                int ny = cy + d[0], nx = cx + d[1];
                int nd = cd + 1;

                // 범위 체크
                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                // 벽 체크
                if (building[ny][nx] == WALL) continue;
                // 방문 여부 체크
                if (fireDist[ny][nx] != -1) continue;

                // 방문 처리
                fireDist[ny][nx] = nd;
                fireQ.offer(new int[]{ny, nx});
            }
        }

        // 상근 탐색
        while (!sQ.isEmpty()) {
            int[] cur = sQ.poll();
            int cy = cur[0], cx = cur[1];
            int cd = sDist[cy][cx];

            // 4방향
            for (int[] d : DIR) {
                int ny = cy + d[0], nx = cx + d[1];
                int nd = cd + 1;

                // 빌딩 탈출 여부 체크
                if (ny < 0 || ny >= H || nx < 0 || nx >= W) {
                    return String.valueOf(nd);
                }

                // 벽 체크
                if (building[ny][nx] == WALL) continue;
                // 방문 여부 체크
                if (sDist[ny][nx] != -1) continue;
                // 불 체크
                if (fireDist[ny][nx] != -1 && nd >= fireDist[ny][nx]) continue;

                // 방문 처리
                sDist[ny][nx] = nd;
                sQ.offer(new int[]{ny, nx});
            }
        }

        // 조기 반환 실패 시 불가능 판정
        return "IMPOSSIBLE";
    }
}

/* 문제
- 상근이는 빈 공간과 벽으로 이루어진 건물에 갇혀있다.
- 매 초마다, 불은 동서남북 방향으로 인접한 빈 공간으로 퍼져나간다. -> 상하좌우 + 빈 공간
- 벽에는 불이 붙지 않는다. -> 불 탐색 시 벽 제외
- 상근이도 동서남북 인접한 칸으로 이동하고, 1초가 걸린다.
- 상근이는 벽을 통과할 수 없고, 불이 옮겨진 칸 또는 불이 붙으려는 칸으로 이동할 수 없다
    -> 상근 탐색 시 벽 제외 + 불 제외
- 빌딩의 지도가 주어졌을 때 얼마나 빨리 빌딩을 탈출할 수 있는지 구하자

- 테스트 T
- 너비와 높이 w,h
- . = 빈 공간, # = 벽, @ = 상근이 시작 위치, * = 불

- 각 테스트케이스마다 빌딩 탈출에 가장 빠른 시간 출력하되, 탈출할 수 없는 경우 "IMPOSSIBLE" 출력
 */

/* 메모

 */