package barkingDog.x03;

import java.io.*;

// 1919: 애너그램 만들기
public class _1919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 두 개의 단어 입력받기
        String first = br.readLine();
        String second = br.readLine();

        // 2. 제거해야하는 최소 개수의 문자 수 구하기
        bw.write(String.valueOf(getMinDeletionCount(first, second)));
        bw.flush();
        bw.close();
    }

    private static int getMinDeletionCount(String first, String second) {
        // 1. 배열 초기화
        int[] alphabet = new int[26];

        // 2. 알파벳 초기화
        for (int i = 0; i < first.length(); i++) {
            alphabet[first.charAt(i) - 'a']++;
        }
        for (int i = 0; i < second.length(); i++) {
            alphabet[second.charAt(i) - 'a']--;
        }

        // 3. 카운트
        int count = 0;
        for (int i = 0; i < alphabet.length; i++) {
            count += Math.abs(alphabet[i]);
        }

        return count;
    }
}
