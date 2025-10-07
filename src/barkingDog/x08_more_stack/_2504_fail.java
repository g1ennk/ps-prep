package barkingDog.x08_more_stack;

import java.io.*;
import java.util.ArrayDeque;

// 2504: 괄호의 값
public class _2504_fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 괄호열을 나타내는 문자열 입력받기
        String line = br.readLine();

        // 2. 결과 출력하기
        bw.write(solution(line));
        bw.flush();
    }

    private static int solution(String line) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        return 0;
    }
}

/*
- 올바른 괄호열: (), []
- 올바른 괄호열 안에 있는 애들도 올바른 괄호열
- 올바른 괄호열끼리 결합한 애들도 올바른 괄호열
- 정의
    - () = 2
    - [] = 3
    - (X) = 2 x 값
    - [X] = 3 x 값
    - (XY) = X + Y
- ex) (()[])([])

(()[[]])([])

-2 2 -3 3 -3

sum
num
 */