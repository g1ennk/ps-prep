package barkingDog.x03_search_and_recursion.bfs.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2146_다리_만들기_FAIL {

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int SEA = 0;
    static final int EARTH = 1;

    static int N;
    static int[][] map;
    static int islandNumber = 2;  // 0은 바다, 1은 땅이므로 2부터 시작

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정보 초기화
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 입력
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 결과 출력
        System.out.println(solution());
    }

    static int solution() {

        // 1. 섬 라벨링
        labelingIsland();

        // 2. 땅 주변 인접한 바다 위치 찾기
        ArrayDeque<int[]> queue = findSeaPosNearEarth();

        // 3. 섬끼리의 최소 거리 구하기
        int minDist = 0;

        return minDist;
    }



    // 섬 라벨링: map의 섬을 구분하기 위해 2,3,4,...로 덮어쓴다
    private static void labelingIsland() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == EARTH) {
                    bfsLabel(y, x);
                    islandNumber++;
                }
            }
        }
    }

    // BFS로 같은 섬을 전부 islandNumber로 칠한다.
    private static void bfsLabel(int sy, int sx) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 초기 방문 처리
        map[sy][sx] = islandNumber;
        queue.offer(new int[]{sy, sx});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cy = pos[0], cx = pos[1];

            // 4방향 탐색
            for (int[] d : DIR) {
                int ny = cy + d[0], nx = cx + d[1];

                // 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                // 초기 땅(1)인 곳만
                if (map[ny][nx] != EARTH) continue;

                // 방문 처리
                map[ny][nx] = islandNumber;
                queue.offer(new int[]{ny, nx});
            }
        }
    }

    // 땅 주변 인접한 바다 위치 찾기
    private static ArrayDeque<int[]> findSeaPosNearEarth() {
        boolean[][] visited = new boolean[N][N];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {

                // 라벨링된 섬만 체크
                if (map[y][x] >= 2) {

                    // 4방향 탐색
                    for (int[] d : DIR) {
                        int ny = y + d[0], nx = x + d[1];

                        // 범위 처리
                        if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                        // 방문 체크
                        if (visited[ny][nx]) continue;

                        // 바다가 아니면 패스
                        if (map[ny][nx] != SEA) continue;

                        // 방문 처리
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx, map[y][x]});
                    }
                }
            }
        }


        return queue;
    }


}

/* 메모
- 여러 섬이 있는데 섬을 잇는 다리를 만들고자 함.
- 마음이 바뀌어서 섬을 잇는 다리를 한 개만 만들고자 하고, 이 또한 최대한 짧게 만들고자 함.
- NxN 크기, 섬은 동서남북으로 육지가 붙어있는 땅, 가장 짧은 다리로 두 대륙을 연결하고자 함.
- 가장 짧은 다리는 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리
- 지도가 주어질 때 가장 짧은 다리 하나를 놓아 두 대륙을 연결해라

- 0은 바다, 1은 육지

10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0

10 + 9 + 7 = 26 -> 오케이 땅에 인접한 바다 위치 파악 끝
 */