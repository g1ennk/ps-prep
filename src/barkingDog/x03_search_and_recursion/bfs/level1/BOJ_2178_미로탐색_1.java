package barkingDog.x03_search_and_recursion.bfs.level1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 미로 탐색(TRY:2)
public class BOJ_2178_미로탐색_1 {

    static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < M; x++) {
                board[y][x] = line.charAt(x) - '0'; // char -> int 변환
            }
        }

        // 풀이
        int answer = solution(board);

        // 출력
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    public static int solution(int[][] board) {
        // 초기화
        int N = board.length, M = board[0].length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        // 초기 방문 처리 (0,0)
        dist[0][0] = 1;
        queue.offer(new int[]{0, 0});

        // 탐색
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1], cd = dist[cy][cx];

            // 종료 조건 체크
            if (cy == N - 1 && cx == M - 1) return cd;

            for (int[] dir : DIR) {
                int ny = cy + dir[0], nx = cx + dir[1], nd = cd + 1;

                // 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                // 방문여부 및 벽 체크
                if (dist[ny][nx] != -1 || board[ny][nx] == 0) continue;

                // 방문 체크
                dist[ny][nx] = nd;
                queue.offer(new int[]{ny, nx});
            }
        }

        // 도달 불가능
        return 0;
    }
}

/* 메모
- 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
- 출발은 (1,1), (N,M) 도달 시 지나야 하는 최소 칸 수 구하기 = 거리 구하기
- 칸 카운트 시 시작 위치와 도착 위치도 포함

- board[y][x] = line.charAt(x) - '0'; // char -> int 변환
- 범위 체크 유의, 문제에선 (1,1)에서 출발한다고 했지만 배열상 (0,0)이 맞음
- 거리 배열로 방문 처리와 거리를 한 번에 처리함.
 */
