package barkingDog.x02;

import java.io.*;
import java.util.StringTokenizer;

// 1000: A+B
public class _1000 {
    public static void main(String[] args) throws IOException {
        // 0. 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. A와 B 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 2. A와 B를 더한 값을 출력하기
        bw.write(a + b + "\n");
        bw.flush();
        bw.close();
    }
}
