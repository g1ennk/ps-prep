package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 7562: 나이트의이동
public class _7562_나이트의이동 {

    static final int[][] DIR = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1. 테스트 케이스 개수 입력받기
        int T = Integer.parseInt(br.readLine());

        // 2. 테스트 케이스 수행
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            // 체크판의 크기
            int size = Integer.parseInt(br.readLine());

            // 나이트의 현재 위치
            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());

            // 나이트의 타겟 위치
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            // 수행
            sb.append(solution(size, cy, cx, ty, tx)).append("\n");
        }

        // 3. 출력
        bw.write(sb.toString());
        bw.flush();
    }

    static int solution(int size, int cy, int cx, int ty, int tx) {
        // 초기화
        int[][] chessBoard = new int[size][size]; // 거리
        boolean[][] visited = new boolean[size][size]; // 방문 여부
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 시작 위치 방문 처리
        q.offer(new int[]{cy, cx});
        chessBoard[cy][cx] = 0; // 초기 거리는 0
        visited[cy][cx] = true; // 방문 처리

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int d = chessBoard[y][x];

            // 도달 검증 후 검증 완료 시 거리값 반환
            if (y == ty && x == tx) {
                return chessBoard[y][x];
            }

            // 8개 방향 탐색
            for (int[] dir : DIR) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                int nd = d + 1;

                // 조건 체크
                if (ny < 0 || ny >= size || nx < 0 || nx >= size) continue;
                if (visited[ny][nx]) continue;

                // 방문 처리
                visited[ny][nx] = true;
                chessBoard[ny][nx] = nd;
                q.offer(new int[]{ny, nx});
            }
        }

        return 0; // 도달 불가능
    }
}
