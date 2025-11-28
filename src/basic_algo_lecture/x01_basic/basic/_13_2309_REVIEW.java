package basic_algo_lecture.x01_basic.basic;

import java.io.*;
import java.util.Arrays;

// 일곱 난쟁이(TRY:2)
public class _13_2309_REVIEW {

    static final int N = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int[] array = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            array[i] = num;
            sum += num;
        }

        // 풀이
        String answer = solution(array, sum);

        // 출력
        bw.write(answer);
        bw.flush();
    }

    static String solution(int[] array, int sum) {
        int fakeA = 0, fakeB = 0;
        boolean found = false;

        // 가짜 찾기
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (sum - (array[i] + array[j]) == 100) {
                    fakeA = array[i];
                    fakeB = array[j];
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        // 오름차순 정렬 후 반환
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == fakeA || array[i] == fakeB) continue;
            sb.append(array[i]).append("\n");
        }
        return sb.toString();
    }

}

/* 메모
- 일곱 난쟁이가 9명이였다.
- 일곱 난쟁이의 키 총합이 100
- 9명의 난쟁이의 키가 주어졌을 때, 일곱 난쟁이를 찾자
- 출력 시 오름차순 정렬
 */
