package barkingDog.x03;

import java.io.*;

// 2577: 숫자의 개수
public class _2577 {

    static final int INPUT_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // TODO: 문제 풀이 작성
        // 1. 배열 초기화
        int[] numbers = new int[10];

        // 2. 세 개의 자연수 입력받고 곱한 후 문자열로 전환
        int multiplyResult = 1;
        for (int i = 0; i < INPUT_COUNT; i++) {
            multiplyResult *= Integer.parseInt(br.readLine());
        }
        String strResult = String.valueOf(multiplyResult);

        // 3. 배열에 카운트
        for (int i = 0; i < strResult.length(); i++) {
            numbers[strResult.charAt(i) - '0']++;
        }

        // 4. 출력하기
        for (int i = 0; i < numbers.length; i++) {
            bw.write((numbers[i]) + "\n");
        }
        bw.flush();
    }
}
