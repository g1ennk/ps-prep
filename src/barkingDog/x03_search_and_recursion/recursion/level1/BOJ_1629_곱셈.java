package barkingDog.x03_search_and_recursion.recursion.level1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(powMod(A, B, C)));
        bw.flush();
    }

    // A를 B번 곱한 수를 나눈 나머지: (A^B) % C
    static long powMod(long A, long B, long C) {
        // 종료 조건
        if (B == 0) return 1 % C;
        if (B == 1) return A % C;

        // 분할 정복
        long half = powMod(A, B / 2, C);
        long result = (half * half) % C;

        // 짝수인 경우 바로 반환, 홀수인 경우 한 번 더 곱하기
        return (B % 2 == 0) ? result : (result * (A % C)) % C;
    }

}
