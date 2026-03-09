package barkingDog.x01_basic.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {

    static final int TOTAL_COUNT = 9;
    static final int COUNT = 7;
    static final int SUM = 100;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[TOTAL_COUNT];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 로직
        int[] answer = solution(arr);

        // 출력
        for (int h : answer) {
            System.out.println(h);
        }
    }

    static int[] solution(int[] arr) {
        // 9명 전체 합 구하기
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        // 가짜 찾기
        int target = totalSum - SUM;
        int fake1 = -1, fake2 = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
            if (fake1 != -1) break;
        }

        // 정답 구성
        int[] answer = new int[COUNT];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == fake1 || i == fake2) continue;
            answer[index] = arr[i];
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
