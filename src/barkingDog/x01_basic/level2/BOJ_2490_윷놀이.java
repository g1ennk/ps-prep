package barkingDog.x01_basic.level2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2490_윷놀이 {

    static final int N = 3; // 윷 던지기 횟수
    static final int BELLY = 0; // 배

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 3번 던지기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            bw.write(resolveYutResult(line));
            bw.newLine();
        }

        // 2. 결과 출력하기
        bw.flush();
    }


    static char resolveYutResult(String inputLine) {
        int bellyCount = countBelly(inputLine);
        return mapToYutSymbol(bellyCount);
    }

    private static int countBelly(String inputLine) {
        int count = 0;
        StringTokenizer st = new StringTokenizer(inputLine);

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num == BELLY) count++;
        }

        return count;
    }

    private static char mapToYutSymbol(int bellyCount) {
        switch (bellyCount) {
            case 1:
                return 'A'; // 도
            case 2:
                return 'B'; // 개
            case 3:
                return 'C'; // 걸
            case 4:
                return 'D'; // 윷
            default:
                return 'E'; // 모(배 0)
        }
    }


}
