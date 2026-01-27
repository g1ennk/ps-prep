package barkingDog.x03_search_and_recursion.recursion.level1;

import java.io.*;

public class BOJ_11729_하노이탑이동순서 {

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
        // 종료 조건: n==1이면 from -> to로 1회 이동(출력)하고 count++.
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
            return;
        }

        //  n-1개를 from에서 temp로 옮긴다(재귀)
        hanoi(n - 1, from, to, temp);

        // 가장 큰 원반(바닥 원반)을 from에서 to로 옮긴다(출력 + count)
        sb.append(from).append(" ").append(to).append("\n");
        count++;

        // temp에 있는 n-1개를 to로 옮긴다(재귀)
        hanoi(n - 1, temp, from, to);
    }

}