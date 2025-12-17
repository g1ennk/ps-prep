package basic_algo_lecture.x03_search_and_recursion.x09_bfs.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3_1_FAIL {

    static final int MAX = 100_000;

    static int N, K; // 수빈, 동생
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static int[] dist = new int[MAX + 1];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int answer = solve(N, K);

        System.out.println(answer);
    }

    static int solve(int start, int target) {
        for (int i = 0; i < N; i++) dist[i] = -1;

        dist[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int curTime = dist[cur];

            // 종료 조건: 수빈이가 동생의 위치에 도달했을 때
            if (cur == target) return curTime;

            // 앞 이동
            int forward = cur + 1;
            int forwardTime = curTime + 1;
            if ((0 <= forward && forward <= MAX) && (dist[forward] == -1 || dist[forward] < forwardTime)) {
                dist[forward] = forwardTime;
                q.offerLast(forward);
            }

            // 뒤 이동
            int backward = cur - 1;
            int backwardTime = curTime + 1;
            if ((0 <= backward && backward <= MAX) && (dist[backward] == -1 || dist[backward] < backwardTime)) {
                dist[backward] = backwardTime;
                q.offerLast(backward);
            }

            // 순간이동
            int teleport = cur * 2;
            int teleportTime = curTime;
            if ((0 <= teleport && teleport <= MAX) && (dist[teleport] == -1 || dist[teleport] < teleportTime)) {
                dist[teleport] = teleportTime;
                q.offerFirst(backward);
            }

        }

        // 도달 불가능
        return -1;
    }

    static boolean inRange(int pos) {
        return pos >= 0 && pos <= N;
    }

}

