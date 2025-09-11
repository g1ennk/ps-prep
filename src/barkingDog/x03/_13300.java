package barkingDog.x03;

import java.io.*;
import java.util.StringTokenizer;

// 13300: 방 배정
public class _13300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 학생 수와 방 최대 인원
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 총 학생의 수 N
        int K = Integer.parseInt(st.nextToken()); // 한 방에 배정할 수 있는 최대 인원 수 K

        // 2. 성별 × 학년별 카운트
        int[][] students = new int[2][7]; // [gender][grade]
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            students[gender][grade]++;
        }

        // 3. 필요한 방 수 계산 (ceil)
        int total = 0;
        for (int gender = 0; gender < 2; gender++) {
            for (int grade = 1; grade <= 6; grade++) {
                int mates = students[gender][grade];
                if (mates % K == 0) {
                    total += mates / K;
                    continue;
                }
                total += mates / K + 1;
            }
        }

        // 4. 결과 출력하기
        bw.write(String.valueOf(total));
        bw.flush();
    }
}
