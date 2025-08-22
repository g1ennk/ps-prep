package barkingDog.x02;

import java.io.*;
import java.util.*;

// 2752: 세수정렬(리스트 + Collection)
public class _2752_1 {
    public static void main(String[] args) throws IOException {
        // 0. 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 정수 세 개 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        // 2. 오르차순 정렬하기
        Collections.sort(numbers);
        // Collections.sort(numbers, Collections.reverseOrder());

        // 3. 출력하기
        for (int number : numbers) {
            bw.write(number + " ");
        }
        bw.flush();
    }
}
