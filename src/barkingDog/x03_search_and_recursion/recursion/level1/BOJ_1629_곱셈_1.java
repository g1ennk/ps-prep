package barkingDog.x03_search_and_recursion.recursion.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(recur(A, B, C));
    }

    static long recur(long A, long B, long C) {
        // 종료 조건(base case)
        if (B == 0) return 1 % C;
        if (B == 1) return A % C;

        // A^B = (A^(B/2))^2  (짝수),  홀수면 거기에 A를 한 번 더 곱함
        long half = recur(A, B / 2, C);
        long result = (half * half) % C;

        return (B % 2 == 0) ? result : (result * (A % C)) % C;
    }

}
