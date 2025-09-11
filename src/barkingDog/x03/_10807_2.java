package barkingDog.x03;

import java.io.*;
import java.util.StringTokenizer;

// 10807: 개수 세기
public class _10807_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // TODO: 문제 풀이 작성
        // 1. 정수 N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 2. N개의 정수 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 3. 타겟 정수 v 입력받기
        int v = Integer.parseInt(br.readLine());

        // 4. 같은 숫자 찾기
        int count = solution(N, st, v);
        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static int solution(int N, StringTokenizer st, int v) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == v) {
                count++;
            }
        }
        return count;
    }
}
