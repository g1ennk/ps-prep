package basic_algo_lecture.x01_basic;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

// A+B
public class _2_1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // A와 B 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 더하기
        int result = A + B;

        // 출력
        bw.write(String.valueOf(result));
        bw.flush();
    }
}


