package barkingDog.x02;

import java.io.*;
import java.util.StringTokenizer;

// 2490: 윷놀이
public class _2490 {

    static final int ROUND = 3;
    static final int THROWS = 4;
    static final char[] MAP = {'E', 'A', 'B', 'C', 'D'};

    public static void main(String[] args) throws IOException {
        // 0. 초기세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 윳놀이 시작
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ROUND; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int zeros = 0;

            for (int j = 0; j < THROWS; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) zeros++;
            }
            sb.append(MAP[zeros]).append("\n");
        }

        // 2. 결과 출력
        bw.write(sb.toString());
        bw.flush();
    }
}

/* 문제풀이
배 = 0, 등 = 1
도 = A -> 0 1 1 1
개 = B -> 0 0 1 1
걸 = C -> 0 0 0 1
윷 = D -> 0 0 0 0
모 = E -> 1 1 1 1
 */