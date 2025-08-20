package barkingDog.x02;

import java.io.*;
import java.util.StringTokenizer;

// 10871: X보다 작은 수
public class _10871 {
    public static void main(String[] args) throws IOException {
        // 0. 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 1. 수열의 개수 N과 기준값 X 입력받기
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 2. N개의 수열 입력 받기
        st = new StringTokenizer(br.readLine());

        // 3. X보다 작은 숫자 뽑기
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < X) {
                sb.append(num).append(' ');
            }
        }

        // 4. 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
