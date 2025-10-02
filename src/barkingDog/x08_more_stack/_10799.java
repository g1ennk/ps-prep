package barkingDog.x08_more_stack;

import java.io.*;
import java.util.ArrayDeque;

// 10799: 쇠막대기
public class _10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 쇠막대기 조각 수 구하기
        bw.write(String.valueOf(solution(br.readLine())));
        bw.flush();
    }

    private static int solution(String line) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);



        }

        return count;
    }
}

//
/*
((()() ))(())

0 + 3 + 3 + 5 + 6 +
 */