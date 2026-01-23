package barkingDog.x01_basic.level1;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class BOJ_10871_X보다작은수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringJoiner sj = new StringJoiner(" ");

        // 1. N과 X 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 2. 수열 A를 이루는 정수 N 입력받기 (동시에 X보다 작은 수 출력)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < X) sj.add(String.valueOf(num));
        }

        // 3. 결과 출력
        bw.write(sj.toString());
        bw.flush();
    }

}
