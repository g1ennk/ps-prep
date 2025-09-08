package barkingDog.x03;

import java.io.*;

// 10808: 알파벳 개수
public class _10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // TODO: 문제 풀이 작성
        // 1. 배열 초기화
        int[] alphabets = new int[26];

        // 2. 단어 S 입력받기
        String S = br.readLine();

        // 3. 하나씩 뽑으면서 위치 알아낸 후 배열에 저장
        for (int i = 0; i < S.length(); i++) {
            alphabets[S.charAt(i) - 'a']++;
        }

        // 4. 출력하기
        for (int i = 0; i < alphabets.length; i++) {
            bw.write(alphabets[i] + " ");
        }
        bw.flush();
    }

}
