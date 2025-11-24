package basic_algo_lecture.x01_basic;

import java.io.*;
import java.util.StringTokenizer;

// 사칙연산
public class _5_10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // A와 B 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 사칙연산
        bw.write(A + B + "\n");
        bw.write(A - B + "\n");
        bw.write(A * B + "\n");
        bw.write(A / B + "\n");
        bw.write(A % B + "\n");

        // 출력
        bw.flush();
    }
}


