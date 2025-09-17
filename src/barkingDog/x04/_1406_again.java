package barkingDog.x04;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

// 1406: 에디터

public class _1406_again {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 초기 문자열 입력받기
        String initStr = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < initStr.length(); i++) {
            list.add(initStr.charAt(i));
        }

        // 2. 명령어의 개수 M 입력받기
        int M = Integer.parseInt(br.readLine());

        // 3. 명령어 입력받기
        String[] commands = new String[M];
        for (int i = 0; i < M; i++) {
            commands[i] = br.readLine();
        }

        // 4. 결과 출력하기
        bw.write(solution2(list, commands));
        bw.flush();
        bw.close();
    }

    // 시도 1: 연결리스트로만 구현 -> 시간 초과
    private static String solution1(LinkedList<Character> list, String[] commands) {
        int cursor = list.size();

        for (String command : commands) {
            char cmd = command.charAt(0);
            switch (cmd) {
                case 'L':
                    if (cursor > 0) cursor--;
                    break;
                case 'D':
                    if (cursor < list.size()) cursor++;
                    break;
                case 'B':
                    if (cursor > 0) {
                        list.remove(cursor - 1);
                        cursor--;
                    }
                    break;
                case 'P':
                    char character = command.charAt(2);
                    list.add(cursor, character);
                    cursor++;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }

    // 시도 2: ListIterator 사용 -> 성공
    private static String solution2(LinkedList<Character> list, String[] commands) {
        ListIterator<Character> it = list.listIterator(list.size()); // 초기 커서 위치 세팅

        for (String command : commands) {
            char cmd = command.charAt(0);

            switch (cmd) {
                case 'L':
                    if (it.hasPrevious()) it.previous();
                    break;
                case 'D':
                    if (it.hasNext()) it.next();
                    break;
                case 'B':
                    if (it.hasPrevious()) {
                        it.previous(); // move to the left character
                        it.remove();   // remove that character
                    }
                    break;
                case 'P':
                    char character = command.charAt(2);
                    it.add(character);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }

}