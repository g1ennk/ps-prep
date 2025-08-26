package barkingDog.x02;

import java.io.*;
import java.util.StringTokenizer;

// 10804: 카드 역배치
public class _10804 {

    static final int N = 10;
    static final int[] array = new int[20];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 0. 배열 초기화
        for (int i = 0; i < 20; i++) {
            array[i] = i + 1;
        }

        // 1. 시작지점과 끝지점 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            reverse(start, end);
        }

        // 2. 전체 배열 출력하기
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void reverse(int start, int end) {
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            int temp = array[start + i - 1];
            array[start + i - 1] = array[end - i - 1];
            array[end - i - 1] = temp;
        }
    }

}