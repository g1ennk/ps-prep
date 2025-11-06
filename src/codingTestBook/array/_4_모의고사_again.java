package codingTestBook.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4_모의고사_again {
    public static void main(String[] args) {
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        System.out.println(Arrays.toString(solution(answers1)));
        System.out.println(Arrays.toString(solution(answers2)));
    }

    static int[] solution(int[] answers) {
        // 1. 수포자들의 패턴 초기화
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 2. 점수 배열
        int[] scores = new int[3];

        // 3. 정답 일치 확인 (모듈러 활용)
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) scores[0]++;
            if (answers[i] == second[i % second.length]) scores[1]++;
            if (answers[i] == third[i % third.length]) scores[2]++;
        }

        // 4. 최고점수 구하기
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 5. 동점자 찾기
        List<Integer> topScorers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == max) {
                topScorers.add(i + 1); // 1번부터 시작
            }
        }

        // 6. 배열 변환
        int[] result = new int[topScorers.size()];
        for (int i = 0; i < topScorers.size(); i++) {
            result[i] = topScorers.get(i);
        }

        return result;
    }
}
