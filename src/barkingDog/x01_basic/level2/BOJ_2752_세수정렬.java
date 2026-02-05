package barkingDog.x01_basic.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class BOJ_2752_세수정렬 {

    static final int LENGTH = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 정수 세 개 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[LENGTH];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 결과 출력
        System.out.println(order(arr));
        // System.out.println(reverseOrder(arr));
    }

    static String order(int[] arr) {
        StringJoiner sj = new StringJoiner(" ");

        // 오름차순 정렬
        Arrays.sort(arr);

        // 반환
        for (int num : arr) {
            sj.add(String.valueOf(num));
        }
        return sj.toString();
    }

    static String reverseOrder(int[] arr) {
        StringJoiner sj = new StringJoiner(" ");

        // int[] -> Integer[] 변환
        Integer[] reverseArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // 내림차순 정렬
        Arrays.sort(reverseArr, Collections.reverseOrder());

        // 반환
        for (int num : reverseArr) {
            sj.add(String.valueOf(num));
        }
        return sj.toString();
    }

}
