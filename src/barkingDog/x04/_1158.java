package barkingDog.x04;

import java.io.*;
import java.util.LinkedList;
import java.util.StringJoiner;
import java.util.StringTokenizer;

// 1158: 요세푸스 문제
public class _1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n과 k 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 2. 결과 출력하기
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(getJosephusProblem(n, k)).append(">");
        bw.write(sb.toString());
        bw.flush();
    }

    private static String getJosephusProblem(int n, int k) {
        LinkedList<Integer> circles = new LinkedList<>();
        StringJoiner sj = new StringJoiner(", ");

        // 리스트 초기화
        for (int i = 1; i <= n; i++) {
            circles.add(i);
        }
        // 리스트가 빌 때까지 반복
        int cursor = 0;
        while (circles.size() > 0) {
            cursor = (cursor - 1 + k) % circles.size();
            sj.add(circles.remove(cursor).toString());
        }

        return sj.toString();
    }
}