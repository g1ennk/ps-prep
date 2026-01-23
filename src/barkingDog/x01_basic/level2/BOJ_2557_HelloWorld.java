package barkingDog.x01_basic.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BOJ_2557_HelloWorld {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. Hello World! 출력
        bw.write("Hello World!");
        bw.flush();
    }

}
