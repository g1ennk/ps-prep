package barkingDog.x07_deck;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringJoiner;

// 5430: AC
public class _5430_fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 각 테스트 케이스의 개수 T
        int T = Integer.parseInt(br.readLine());

        // 2. 테스트 케이스 수만큼 실행
        StringJoiner finalResult = new StringJoiner("\n");
        boolean reverseFlag = false; // 초기 정방향 (뒤집어지지 않은 상태)
        for (int i = 0; i < T; i++) {
            // 명령어 입력받기
            String commands = br.readLine();

            // 배열에 들어있는 수의 개수 n 입력받기
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                finalResult.add("error");
                continue;
            }

            // 배열에 들어있는 수 파싱하여 입력받기
            ArrayDeque<Integer> deck = new ArrayDeque<>();
            String arrayString = br.readLine();
            String[] array = arrayString.substring(1, arrayString.length() - 1).split(",");
            for (String number : array) {
                deck.addLast(Integer.parseInt(number));
            }

            // 명령어 수행하기
            for (int j = 0; j < commands.length(); j++) {
                char command = commands.charAt(j);
                switch (command) {
                    // 뒤집기
                    case 'R': {
                        reverseFlag = !reverseFlag; // 계속 방향이 바뀔 수 있음
                        break;
                    }
                    // 앞에 수 제거
                    case 'D': {
                        // 덱이 비어있는 상태라면 error
                        if (deck.isEmpty()) {
                            finalResult.add("error");
                            break;
                        }
                        // 역방향
                        if (reverseFlag) {
                            deck.removeFirst();
                            break;
                        }
                        // 정방향
                        deck.removeLast();
                    }
                }
            }

            // 결과 조합하기
            StringBuilder result = new StringBuilder().append("[");
            StringJoiner sj = new StringJoiner(",");
            for (Integer number : deck) {
                sj.add(String.valueOf(number));
            }
            result.append(sj);
            result.append("]");
            finalResult.add(result.toString());
        }

        // 최종 결과 출력하기
        bw.write(finalResult.toString());
        bw.flush();
    }
}

/*
- 두 가지 함수
    - R 뒤집기: 배열의 순서를 뒤집는 함수
    - D 버리기: 첫 번째 순서를 버리는 함수 (비어있는 경우 예외 처리 필요)
- 배열의 초기값과 수행할 함수가 주어졌을 때 최종 결과
- 첫 째줄은 테스트 케이스 수 T
- 다음 줄은 수행할 함수 p, 그 다음 줄은 배열에 들어있는 수의 개수 n, 다음 줄에는 배열에 들어있는 정수
 */