package barkingDog.x0B_recursion;

import java.io.*;
import java.util.StringTokenizer;

public class _1629_곱셈_fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. A,B,C 입력받기 - 10 11 12
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken()); // mod

        // 2. 출력하기
        bw.write(String.valueOf(recursion(A, B, C)));
        bw.flush();
    }

    // 시도 1: 마지막에만 mod -> 틀렸습니다
    static long wrong(long a, long b, long mod) {
        long val = 1;
        while (b > 0) {
            val *= a;
            b--;
        }
        return val % mod;
    }

    // 시도 2: 매 스텝마다 mod -> 시간 초과
    static long timeLimit(long a, long b, long mod) {
        long val = 1;
        long base = a % mod;
        while (b > 0) {
            val = (val * base) % mod;
            b--;
        }
        return val;
    }

    // 시도 3: 단순 재귀 -> 성공
    static long recursion(long a, long b, long mod) {
        if (b == 0) return 1 % mod;
        if (b == 1) return a % mod;

        long val = recursion(a, b / 2, mod);
        val = (val * val) % mod;

        if (b % 2 == 0) return val; // 짝수일 때
        return ((a % mod) * val) % mod; // 홀수일 때
    }

}

/*
- 짝수 b = 2k: a^b = a^2k = (a^k)^2 = 절반 지수의 a^k 값만 알면 그걸 제곱하면 끝
- 홀수 b= 2k + 1: a^b = a^2k+1 = (a^k)^2 * a = 제곱 후 a를 한 번만 더 곱하면 끝
 */