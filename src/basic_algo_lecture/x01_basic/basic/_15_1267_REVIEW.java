package basic_algo_lecture.x01_basic.basic;

import java.io.*;
import java.util.StringTokenizer;

// 핸드폰 요금(TRY:2)
public class _15_1267_REVIEW {

    static final int Y_INTERVAL = 30;
    static final int Y_COST = 10;
    static final int M_INTERVAL = 60;
    static final int M_COST = 15;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 통화 횟수 입력
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int yTotal = 0, mTotal = 0;

        // 2. 통화 시간별 요금 누적 계산
        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            yTotal += calculate(time, Y_INTERVAL, Y_COST);
            mTotal += calculate(time, M_INTERVAL, M_COST);
        }

        // 3. 저렴한 요금제 출력
        if (yTotal < mTotal) {
            bw.write("Y " + yTotal);
        } else if (yTotal > mTotal) {
            bw.write("M " + mTotal);
        } else {
            bw.write("Y M " + yTotal); // 같을 경우
        }

        // 4. 출력
        bw.flush();
    }

    private static int calculate(int time, int interval, int cost) {
        return (time / interval + 1) * cost;
    }

}

/* 메모
문제
- 영식 요금제: 30초마다 10원씩 청구
- 민식 요금제: 60초마다 15원씩 청구
- 통화 시간 목록이 주어지면 어느 요금제를 사용하는 것이 저렴한지 출력

입력
- 통화 개수 N 주어지고, 다음 줄에 통화 시간 N개가 주어짐

출력
- 첫 째줄에 싼 요금제 이름을 출력하고, 공백 후 몇 원 나오는지 출력
- 만약 두 요금제가 같으면 영식을 먼저 쓰고 민식을 다음에 쓴다.
- 영식 = Y, 민식 = M
 */
