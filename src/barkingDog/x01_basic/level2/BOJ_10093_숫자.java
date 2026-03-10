package barkingDog.x01_basic.level2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10093_숫자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 출력
        bw.write(solution(A, B));
        bw.flush();
    }

    public static String solution(long A, long B) {
        StringBuilder sb = new StringBuilder();

        // 1. 두 수 사이에 있는 수의 개수
        long max = Math.max(A, B);
        long min = Math.min(A, B);
        long betweenCount = Math.max(0, max - min - 1); // 실수 Point: A와 B가 같은 경우에는?
        sb.append(betweenCount + "\n");

        // 2. 두 수 사이에 있는 수를 오름차순으로 정렬
        for (long i = min + 1; i < max; i++) {
            sb.append(i + " ");
        }

        // 3. 반환
        return sb.toString();
    }

}
