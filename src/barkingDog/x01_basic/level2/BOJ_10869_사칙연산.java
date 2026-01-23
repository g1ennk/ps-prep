package barkingDog.x01_basic.level2;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class BOJ_10869_사칙연산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 두 자연수 A,B 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 2. 결과 출력하기
        bw.write(solve(A, B));
        bw.flush();
    }

    public static String solve(int A, int B) {
        StringJoiner sj = new StringJoiner("\n");

        sj.add(String.valueOf(A + B));
        sj.add(String.valueOf(A - B));
        sj.add(String.valueOf(A * B));
        sj.add(String.valueOf(A / B));
        sj.add(String.valueOf(A % B));

        return sj.toString();
    }

}
