package barkingDog.x01_basic.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2587_대표값2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int[] result = solution(numbers);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] solution(int[] numbers) {
        Arrays.sort(numbers);

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        int avg = sum / numbers.length;
        int mid = numbers[numbers.length / 2];

        return new int[]{avg, mid};
    }

}
