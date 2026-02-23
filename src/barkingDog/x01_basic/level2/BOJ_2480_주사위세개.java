package barkingDog.x01_basic.level2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2480_주사위세개 {

    static final int ALL_SAME_BONUS = 10000;
    static final int ALL_SAME_MULTIPLIER = 1000;
    static final int TWO_SAME_BONUS = 1000;
    static final int SAME_MULTIPLIER = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 주사위 3개 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int d3 = Integer.parseInt(st.nextToken());

        // 2. 결과 판단하기
        bw.write(String.valueOf(calculatePrize(d1, d2, d3)));
        bw.flush();
    }

    static int calculatePrize(int d1, int d2, int d3) {
        // 3개 모두 같은 경우
        if (d1 == d2 && d2 == d3) {
            return ALL_SAME_BONUS + d1 * ALL_SAME_MULTIPLIER;
        }

        // 세 개 모두 다른 경우
        if (d1 != d2 && d2 != d3 && d1 != d3) {
            int max = Math.max(d1, Math.max(d2, d3));
            return max * SAME_MULTIPLIER;
        }

        // 두 개만 같은 경우
        int same = d1;
        if (d2 == d3) same = d2;
        return TWO_SAME_BONUS + same * SAME_MULTIPLIER;
    }

}
