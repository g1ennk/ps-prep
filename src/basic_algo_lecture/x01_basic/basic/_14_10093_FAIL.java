package basic_algo_lecture.x01_basic.basic;

import java.io.*;
import java.util.StringTokenizer;

// 숫자(TRY:2)
public class _14_10093_FAIL {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 작은 값, 큰 값 구하기
        long max = Math.max(A, B);
        long min = Math.min(A, B);

        // 사이 개수 계산
        long count = 0;
        if (max > min) {
            count = max - min - 1;
        }

        // 사이 개수 출력
        bw.write(count + "\n");

        // 숫자 출력
        for (long i = min + 1; i < max; i++) {
            bw.write(i + " ");
        }

        bw.flush();
    }


}

/* 메모
- 문제 조건 잘 확인해서 타입 정확하게 하기
 */