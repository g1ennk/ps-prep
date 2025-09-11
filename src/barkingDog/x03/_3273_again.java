package barkingDog.x03;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3273: 두 수의 합: again
public class _3273_again {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수열의 크기 n 입력받기
        int n = Integer.parseInt(br.readLine());

        // 2. n개의 수열 입력받기
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 자연수 x 입력받기
        int x = Integer.parseInt(br.readLine());

        // 4. 쌍의 개수 구하기
        int answer = solution(array, x);
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static int solution(int[] array, int x) {
        Arrays.sort(array);

        int count = 0;
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == x) {
                count++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
