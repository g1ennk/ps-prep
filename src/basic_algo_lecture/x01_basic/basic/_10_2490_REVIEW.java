package basic_algo_lecture.x01_basic.basic;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

// 윷놀이(TRY:2)
public class _10_2490_REVIEW {

    static final int ROUND = 3;
    static final int THROWS = 4;
    static final String[] MAP = {"E", "A", "B", "C", "D"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 및 풀이
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < ROUND; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int zeroCount = 0;
            for (int j = 0; j < THROWS; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) zeroCount++;
            }
            sj.add(MAP[zeroCount]);
        }

        // 출력
        bw.write(sj.toString());
        bw.flush();
    }
}

/* 메모
도 - 0 1 1 1 - A
개 - 0 0 1 1 - B
걸 - 0 0 0 1 - C
윷 - 0 0 0 0 - D
모 - 1 1 1 1 - E
 */
