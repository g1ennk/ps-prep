package basic_algo_lecture.x01_basic.practice;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

// X보다 작은 수
public class _1_10871_DONE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringJoiner sj = new StringJoiner(" ");

        // 수열의 개수 N과 기준값 X 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // N개의 수열 입력 및 판별
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < X) {
                sj.add(String.valueOf(num));
            }
        }

        // 출력
        bw.write(sj.toString());
        bw.flush();
    }
}


