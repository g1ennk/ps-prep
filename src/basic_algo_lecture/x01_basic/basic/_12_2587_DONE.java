package basic_algo_lecture.x01_basic.basic;

import java.io.*;
import java.util.Arrays;

// 대표값2(TRY:2)
public class _12_2587_DONE {

    static final int N = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int sum = 0;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
            sum += array[i];
        }

        // 출력
        bw.write(getAvg(sum) + "\n" + getMid(array));
        bw.flush();
    }

    static int getAvg(int sum) {
        return sum / N;
    }

    static int getMid(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }

}

/* 메모
- 다섯 개의 자연수가 주어짐
- 평균값과 중앙값 구하기
 */
