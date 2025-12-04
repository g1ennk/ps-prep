package basic_algo_lecture.x03_search_and_recursion.x09_bfs.practice;

import java.io.*;
import java.util.ArrayDeque;

// 적록색약 (TRY:2)
public class _7_10026_REVIEW {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N 입력
        N = Integer.parseInt(br.readLine());

        // 2. 초기화
        char[][] normal = new char[N][N]; // 비색약
        char[][] blind = new char[N][N]; // 적록색약

        // 3. 그림 입력
        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < N; x++) {
                char color = line.charAt(x);
                normal[y][x] = color;
                blind[y][x] = (color == 'G') ? 'R' : color; // G를 R로 대체
            }
        }

        // 4. 비색약, 적록색약 세기
        int nonColorBlind = count(normal);
        int colorBlind = count(blind);

        // 5. 결과 출력
        bw.write(nonColorBlind + " " + colorBlind);
        bw.flush();
    }

    // 구역의 개수 세기
    private static int count(char[][] painting) {
        int count = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                // 방문한 곳이라면 패스
                if (painting[y][x] == 'V') continue;

                // BFS 처리
                char color = painting[y][x];
                bfs(y, x, color, painting);
                count++;
            }
        }

        return count;
    }

    // BFS 탐색
    private static void bfs(int sy, int sx, char color, char[][] painting) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 초기 방문 처리
        painting[sy][sx] = 'V';
        queue.offer(new int[]{sy, sx});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cy = curr[0], cx = curr[1];

            for (int[] d : DIR) {
                int ny = cy + d[0];
                int nx = cx + d[1];

                // 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                // 방문 체크
                if (painting[ny][nx] == 'V') continue;
                // 초기 색깔과 같은지 체크
                if (painting[ny][nx] != color) continue;

                // 방문 체크
                queue.offer(new int[]{ny, nx});
                painting[ny][nx] = 'V';
            }
        }

    }

}

/* 문제
- 적록색약은 빨간색과 초록색의 차이를 느끼지 못한다. 빨 = 초
- 크기가 NxN 그리드에 R,G,B 그림이 있다.
- 같은 색으로 모여있는 것이 구역
- 그림이 주어졌을 때, 적록색약인 사람이 봤을 때의 구역의 개수와 아닌 사람이 봤을 때 구역의 개수를 구해라
 */

/* 입출력
- N이 입력
- 그림이 주어지고
- 아닌 사림의 개수와 맞는 사람의 개수를 공백으로 구분해 출력
 */

/* 메모

 */