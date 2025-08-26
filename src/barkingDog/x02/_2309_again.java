package barkingDog.x02;

import java.io.*;
import java.util.Arrays;

// 2309: 일곱 난쟁이
public class _2309_again {

    static final int N = 9;
    static final int fakeCount = N - 7;
    static final int REAL_TOTAL_HEIGHTS = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 9명의 키 입력 받기
        int[] dwarves = new int[N];
        int fakeTotalHeights = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            dwarves[i] = height;
            fakeTotalHeights += height;
        }

        // 2. 반복문으로 색출
        boolean found = false;
        for (int i = 0; i < N; i++) {
            int target = fakeTotalHeights - REAL_TOTAL_HEIGHTS;
            target -= dwarves[i];
            for (int j = i + 1; j < N; j++) {
                if (target - dwarves[j] == 0) {
                    dwarves[i] = 0;
                    dwarves[j] = 0;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        // 3. 정답 정렬 후 출력하기
        Arrays.sort(dwarves);
        for (int i = fakeCount; i < N; i++) {
            bw.write(dwarves[i] + "\n");
        }
        bw.flush();
    }
}

/*
- 일곱 난쟁이가 아닌 아홉명
- 일곱 난쟁이의 키 합이 100
 */