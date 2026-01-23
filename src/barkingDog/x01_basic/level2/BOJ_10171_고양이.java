package barkingDog.x01_basic.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringJoiner;

public class BOJ_10171_고양이 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringJoiner sj = new StringJoiner("\n");

        // 고양이
        sj.add("\\    /\\");
        sj.add(" )  ( ')");
        sj.add("(  /  )");
        sj.add(" \\(__)|");

        // 출력
        bw.write(sj.toString());
        bw.flush();
    }
}
