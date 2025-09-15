package barkingDog.x03;

import java.io.*;
import java.util.StringTokenizer;

// 11328: Strfry
public class _11328 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수 입력받기
        int N = Integer.parseInt(br.readLine());

        // 2. 테스트 케이스 수 실행
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            sb.append(isStrfryPossible(first, second)).append("\n");
        }

        // 3. 출력하기
        bw.write(sb.toString());
        bw.flush();
    }

    private static String isStrfryPossible(String first, String second) {
        // 0. 초기 예외
        if (first.length() != second.length()) {
            return "Impossible";
        }

        // 1. 2차원 배열 초기화
        int[][] arr = new int[2][26];

        // 2. 알파벳 초기화
        for (int i = 0; i < first.length(); i++) {
            arr[0][first.charAt(i) - 'a']++;
            arr[1][second.charAt(i) - 'a']++;
        }

        // 3. 판별하기
        for (int i = 0; i < 26; i++) {
            int firstCount = arr[0][i];
            int secondCount = arr[1][i];

            if (firstCount != secondCount) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}
