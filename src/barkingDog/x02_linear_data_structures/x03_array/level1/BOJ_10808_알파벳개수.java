package barkingDog.x02_linear_data_structures.x03_array.level1;

import java.io.*;
import java.util.StringJoiner;

public class BOJ_10808_알파벳개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 단어 S 입력
        String S = br.readLine();

        // 2. 결과 출력
        bw.write(solve(S));
        bw.flush();
    }

    static String solve(String S) {
        int[] counts = new int[26];

        // 문자 하나씩 배열 카운트에 추가
        for (int i = 0; i < S.length(); i++) {
            // counts[alphabet - 97]++;
            counts[S.charAt(i) - 'a']++;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < 26; i++) {
            sj.add(String.valueOf(counts[i]));
        }

        return sj.toString();
    }

}