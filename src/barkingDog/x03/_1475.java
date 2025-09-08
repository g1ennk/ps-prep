package barkingDog.x03;

import java.io.*;

// 1475: 방 번호
public class _1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // TODO: 문제 풀이 작성
        // 1. 숫자 카운트 배열 초기화
        int[] numbers = new int[10];

        // 2. 방 번호 입력 받기
        String input = br.readLine();

        // 3. 숫자 빈도 세면서 동시에 최댓값 추적
        int maxCount = 0;
        for (int i = 0; i < input.length(); i++) {
            // 인덱스 추출 후 카운트업
            int index = input.charAt(i) - '0';
            numbers[index]++;

            // 현재 숫자의 카운트 횟수
            int count = numbers[index];

            // 예외: 6과 9는 뒤집어 쓸 수 있으므로 합쳐서 계산
            if (index == 6 || index == 9) {
                maxCount = Math.max(maxCount, (numbers[6] + numbers[9] + 1) / 2);
                continue;
            }

            // 최댓값 갱신
            maxCount = Math.max(maxCount, count);
        }

        // 4. 출력
        bw.write(String.valueOf(maxCount));
        bw.flush();
    }
}
