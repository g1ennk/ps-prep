package barkingDog.x09_bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 7576: 토마토 - 시작점이 여러 개일 때
public class _7576_1 {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int M, N; // 가로(x), 세로(y)
    static String[][] container;
    static int[][] dist;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 가로 M, 세로 N 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // x
        N = Integer.parseInt(st.nextToken()); // y

        // 2. 초기화
        container = new String[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        // 3. 토마토 정보 입력받기
        boolean allRaped = true;
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                container[y][x] = st.nextToken();
                if (container[y][x].equals("0")) allRaped = false;
                if (container[y][x].equals("1")) {
                    queue.offer(new int[]{y, x});
                    dist[y][x] = 0;
                }
                if (container[y][x].equals("-1")) dist[y][x] = 0;
            }
        }

        // 4. BFS
        bw.write((allRaped) ? "0" : String.valueOf(solution()));
        bw.flush();
    }

    static int solution() {
        // 1. BFS
        int maxDist = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int curDist = dist[curY][curX];

            // 상하좌우 탐색
            for (int[] dir : DIR) {
                int newY = curY + dir[0];
                int newX = curX + dir[1];
                int newDist = curDist + 1;

                // 예외 체크
                if (newY < 0 || newY >= N || newX < 0 || newX >= M) continue;
                if (dist[newY][newX] != -1) continue;

                // 방문 처리
                queue.offer(new int[]{newY, newX});
                dist[newY][newX] = newDist;
                maxDist = Math.max(maxDist, newDist);
            }
        }

        // 2. 아직 익지 않은 토마토가 있는지 확인
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (dist[y][x] == -1) {
                    return -1;
                }
            }
        }

        return maxDist;
    }

}