package barkingDog.x03_search_and_recursion.recursion.level1;

import java.io.*;

public class BOJ_11729_하노이탑이동순서_1 {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);

        bw.write(count + "\n");
        bw.write(sb.toString());
        bw.flush();
    }

    static void hanoi(int n, int from, int temp, int to) {
        // 종료 조건
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
            return;
        }

        // n-1개를 보조 위치(2번째)로 이동
        hanoi(n - 1, from, to, temp);

        // 가장 밑에 있는 원반을 목표 위치로 이동
        sb.append(from).append(" ").append(to).append("\n");
        count++;

        // 보조 위치에 있던 원반을 목표 위치로 이동
        hanoi(n - 1, temp, from, to);
    }

}