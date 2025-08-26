package barkingDog.x02;

import java.io.*;
import java.util.StringTokenizer;

// 10093: 숫자
public class _10093 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 두 양의 정수 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 2. 큰 수 판별하기
        long low = Math.min(A, B);
        long high = Math.max(A, B);

        // 3. 결과 조합하기
        long count = (low == high) ? 0 : high - low - 1;
        bw.write(count + "\n");
        if (count > 0) {
            for (long i = low + 1; i < high; i++) {
                bw.write(i + " ");
            }
        }
        bw.flush();
    }

}

/* 문제 풀이
- 핵심은 숫자 범위로 int를 쓰면 틀리고, long을 쓰면 정답
- int: +- 2,147,483,647 -> 10^9
- long: +- 9,223,372,036,854,775,807 -> 10^18
 */