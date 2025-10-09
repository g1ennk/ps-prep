package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 7576: 토마토 - 시작점이 여러 개일 때
public class _7576 {

    static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] box; // 방문 처리 없이 박스에 거리 저장
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 상자의 크기 입력받기 (입력 순서 주의)
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 2. 초기화
        box = new int[r][c];
        ArrayDeque<int[]> q = new ArrayDeque<>(); // 익어 있는 위치를 큐 삽입

        // 3. 토마토의 정보 입력받기 (저장될 때부터 모든 토마토가 익어있는 상태면 0 출력)
        boolean isAllRipped = true;
        for (int sr = 0; sr < r; sr++) {
            st = new StringTokenizer(br.readLine());
            for (int sc = 0; sc < c; sc++) {
                box[sr][sc] = Integer.parseInt(st.nextToken());
                if (box[sr][sc] == 0) isAllRipped = false;
                if (box[sr][sc] == 1) {
                    q.offer(new int[]{sr, sc});
                }
            }
        }

        // 4. 저장될 때부터 모든 토마토가 익어있는 상태면 0 출력 후 종료
        if (isAllRipped) {
            bw.write("0");
            bw.flush();
            return;
        }

        // 5. 탐색 (최대 거리 구하기)
        bfs(q);

        // 6. 익지 못한 상황인지 최종 탐색과 동시에 최대 거리 구하기 (모두 익을 수 없는 상태이면 -1 출력)
        boolean notAvailableToRipped = false;
        int maxDist = 1;
        for (int sr = 0; sr < r; sr++) {
            for (int sc = 0; sc < c; sc++) {
                if (box[sr][sc] == 0) notAvailableToRipped = true;
                maxDist = Math.max(maxDist, box[sr][sc]);
            }
        }

        // 7. 결과 출력
        int answer = (notAvailableToRipped ? -1 : maxDist - 1);
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void bfs(ArrayDeque<int[]> q) {
        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int curD = box[curR][curC];

            // 인접 탐색
            for (int[] dir : DIRS) {
                int nR = curR + dir[0];
                int nC = curC + dir[1];
                int nD = curD + 1;

                // 범위 체크
                if (nR < 0 || nR >= r || nC < 0 || nC >= c) continue;
                // 방문 여부 + 토마토가 들어있지 않은 칸 체크 (-1)
                if (box[nR][nC] != 0) continue;

                // 방문 처리
                q.offer(new int[]{nR, nC});
                box[nR][nC] = nD;
            }
        }
    }
}