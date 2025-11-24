package basic_algo_lecture.x01_basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 고양이
public class _4_10171 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        // 조합
        sb.append("\\    /\\\n");
        sb.append(" )  ( ')\n");
        sb.append("(  /  )\n");
        sb.append(" \\(__)|\n");

        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
}


