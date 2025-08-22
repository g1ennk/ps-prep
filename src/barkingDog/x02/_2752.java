package barkingDog.x02;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2752: 세수정렬(정수 배열)
public class _2752 {
    public static void main(String[] args) throws IOException {
        // 0. 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 정수 세 개 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 차례대로 정렬하기
        Arrays.sort(numbers);

        // 3. 출력하기
        for (int number : numbers) {
            bw.write(number + " ");
        }
        bw.flush();
    }
}
