package basic_algo_lecture.x01_basic.basic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세수정렬
public class _7_2752_REVIEW {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정수 세 개 입력
        int[] array = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(array);

        // 출력
        bw.write(array[0] + " " + array[1] + " " + array[2]);
        bw.flush();
    }

}

/* 메모
- 만약 내림차순 정렬하고 싶다면 일반적인 정수 배열에선 Comparator 없이 sorting 후 반대로 출력하는 방식 고려
- 혹은 래퍼 타입으로 변환 후 람다로 정렬하는 방법도 존재 ex) Arrays.sort(arr, (a, b) -> b - a);
 */
