package barkingDog.x04;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

// 5397: 키로거
public class _5397_again {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 입력 받기
        int t = Integer.parseInt(br.readLine());

        // 2. 비밀번호 입력받기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String password = br.readLine();
            sb.append(getPassword(password)).append('\n');
        }

        // 3. 출력하기
        bw.write(sb.toString());
        bw.flush();
    }

    private static String getPassword(String password) {
        // 1. 리스트 및 반복자 초기화
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> it = list.listIterator();

        // 2. 순회하면서 처리
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            switch (c) {
                case '<':
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                    break;
                case '>':
                    if (it.hasNext()) {
                        it.next();
                    }
                    break;
                case '-':
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                default:
                    it.add(c);
                    break;
            }
        }

        // 3. String으로 변환하여 반환
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}