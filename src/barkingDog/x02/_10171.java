package barkingDog.x02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 10171: 고양이
public class _10171 {
    public static void main(String[] args) throws IOException {
        // 1. 초기 세팅
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 출력
        bw.write("\\    /\\\n"); // 역슬래쉬를 출력하기 위해선 앞의 또 다른 역슬래쉬가 필요함
        bw.write(" )  ( ')\n");
        bw.write("(  /  )\n");
        bw.write(" \\(__)|");

        bw.flush();
    }
}
