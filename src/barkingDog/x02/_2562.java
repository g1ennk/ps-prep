package barkingDog.x02;

import java.io.*;

public class _2562 {

    static final int N = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 9의 자연수 입력받기 (동시에 최댓값과 그 인덱스 찾기)
        int max = Integer.MIN_VALUE;
        int maxIndex = 1;
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > max) {
                max = num;
                maxIndex = i;
            }
        }

        // 2. 결과 출력하기
        bw.write(max + "\n" + maxIndex);
        bw.flush();
    }
}
