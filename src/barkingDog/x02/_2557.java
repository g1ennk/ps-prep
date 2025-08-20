package barkingDog.x02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 2557: Hello World
public class _2557 {
    public static void main(String[] args) throws IOException {
        // 0. 초기 세팅
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. Hello World! 출력하기
        bw.write("Hello World!");
        bw.flush();
        bw.close();
    }
}
