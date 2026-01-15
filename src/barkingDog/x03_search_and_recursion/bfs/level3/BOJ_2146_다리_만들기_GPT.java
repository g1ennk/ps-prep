package barkingDog.x03_search_and_recursion.bfs.level3;

import java.io.*;
import java.util.*;

public class BOJ_2146_다리_만들기_GPT {
    static final int SEA = 0;
    static final int LAND = 1;
    static final int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1}};

    static int N;
    static int[][] map;
    static boolean[][] vis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        vis = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 1) 섬 라벨링 (2부터)
        int id = 2;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == LAND && !vis[y][x]) {
                    labelIsland(y, x, id++);
                }
            }
        }

        // 2) 멀티소스 BFS로 최단 다리
        System.out.println(shortestBridge());
    }

    static boolean inRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    static void labelIsland(int sy, int sx, int id) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sy, sx});
        vis[sy][sx] = true;
        map[sy][sx] = id;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int[] d : DIR) {
                int ny = y + d[0], nx = x + d[1];
                if (!inRange(ny, nx)) continue;
                if (vis[ny][nx]) continue;
                if (map[ny][nx] != LAND) continue;

                vis[ny][nx] = true;
                map[ny][nx] = id;
                q.offer(new int[]{ny, nx});
            }
        }
    }

    static int shortestBridge() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] owner = new int[N][N];
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        // 모든 땅을 시작점으로 멀티소스 BFS
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] != SEA) {
                    owner[y][x] = map[y][x];
                    dist[y][x] = 0;
                    q.offer(new int[]{y, x});
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int[] d : DIR) {
                int ny = y + d[0], nx = x + d[1];
                if (!inRange(ny, nx)) continue;

                if (owner[ny][nx] == 0) { // 미점유 바다 확장
                    owner[ny][nx] = owner[y][x];
                    dist[ny][nx] = dist[y][x] + 1;
                    q.offer(new int[]{ny, nx});
                } else if (owner[ny][nx] != owner[y][x]) { // 다른 섬과 만남
                    ans = Math.min(ans, dist[y][x] + dist[ny][nx]);
                }
            }
        }

        return ans;
    }
}
