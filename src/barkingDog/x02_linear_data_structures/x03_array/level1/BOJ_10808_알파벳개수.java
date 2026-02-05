package barkingDog.x02_linear_data_structures.x03_array.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class BOJ_10808_알파벳개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner answer = new StringJoiner(" ");

        // 1. 알파벳 소문자 입력
        String S = br.readLine();

        // 2. 하나씩 알파벳 위치를 추출하고, 하나씩 증가
        int[] alphabetArr = new int[26];
        for (int i = 0; i < S.length(); i++) {
            int alphabetPos = S.charAt(i) - 'a';
            alphabetArr[alphabetPos]++;
        }

        // 3. 알파벳 배열 출력
        for (int i = 0; i < alphabetArr.length; i++) {
            answer.add(String.valueOf(alphabetArr[i]));
        }
        System.out.println(answer);
    }

}
