package barkingDog.x03_search_and_recursion.recursion.level1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1074_Z {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 정수 N, r, c 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 2. 초기 사이즈 설정하기
        int size = 1;
        for (int i = 0; i < N; i++) size *= 2;

        // 3. 결과 출력하기
        bw.write(String.valueOf(solve(size, r, c)));
        bw.flush();
    }

    static int solve(int size, int r, int c) {
        // 종료 조건
        if (size == 1) return 0;

        int half = size / 2;
        int block = half * half;

        if (r < half && c < half) {
            return solve(half, r, c);
        } else if (r < half && c >= half) {
            return block + solve(half, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * block + solve(half, r - half, c);
        } else {
            return 3 * block + solve(half, r - half, c - half);
        }
    }

}

/*
N = 2, r = 3, c = 1 -> target = 11, size = 4

 0  1  4  5
 2  3  6  7
 8  9 12 13
10 11 14 15

1) size = 4
half = 2
block = 4
return 2 * 4 + solve(2, 1, 1)

2) size = 2
half = 1
block = 1
return 3 * 1 + solve(1, 0, 0)

3) size = 1
3 + 8 = 11
 */