package basic_algo_lecture.x01_basic.basic;

import java.io.*;
import java.util.StringTokenizer;

// 주사위 세개
public class _9_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] diceResult = new int[3];
        for (int i = 0; i < diceResult.length; i++) {
            diceResult[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        int answer = calculatePrize(diceResult);

        // 출력
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static int calculatePrize(int[] diceResult) {
        // 가독성을 위한 초기화
        int a = diceResult[0];
        int b = diceResult[1];
        int c = diceResult[2];

        // 모두 같은 눈: 10000 + (같은 눈) x 1000
        if (a == b && b == c) {
            return 10000 + (a * 1000);
        }

        // 모두 다른 눈: 가장 큰 눈 x 100
        if (a != b && b != c && a != c) {
            int max = Math.max(a, (Math.max(b, c)));
            return max * 100;
        }

        // 같은 눈 2개: 1000 + (같은 눈) x 100
        int same = a;
        if (b == c) same = b;
        return 1000 + (same * 100);
    }
}

/* 메모
- 가독성을 위해 배열 인덱스가 아닌 변수 활용하기 a, b, c
- 조기 반환 적극 활용
 */
