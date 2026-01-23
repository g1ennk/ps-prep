package barkingDog.x01_basic.level2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1000_A_Pus_B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. A과 B 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 3. 결과 출력
        bw.write(String.valueOf(A + B));
        bw.flush();
    }

}
