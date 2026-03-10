package barkingDog.x01_basic.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1267_핸드폰요금 {

    static final int Y_EACH = 30;
    static final int Y_PRICE = 10;
    static final int M_EACH = 60;
    static final int M_PRICE = 15;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int N = Integer.parseInt(br.readLine()); // 동화가 저번 달에 이용한 통화의 개수 (0 < N <= 20)
        int[] times = new int[N]; // 통화 시간 N개 (0 < N <= 10,000)

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        // 출력
        bw.write(solution(times));
        bw.flush();
    }

    static String solution(int[] times) {
        int yTotal = calculateTotalCost(Y_EACH, Y_PRICE, times);
        int mTotal = calculateTotalCost(M_EACH, M_PRICE, times);

        if (yTotal < mTotal) {
            return "Y " + yTotal;
        }

        if (mTotal < yTotal) {
            return "M " + mTotal;
        }

        return "Y M " + yTotal;
    }

    static int calculateTotalCost(int unitSeconds, int unitCost, int[] times) {
        int total = 0;

        for (int time : times) {
            total += (time / unitSeconds + 1) * unitCost;
        }

        return total;
    }

}
