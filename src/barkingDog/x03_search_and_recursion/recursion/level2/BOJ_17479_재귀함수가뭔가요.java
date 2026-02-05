package barkingDog.x03_search_and_recursion.recursion.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17479_재귀함수가뭔가요 {

    static final String INDENT = "____";

    static final String INTRO = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    static final String QUESTION = "\"재귀함수가 뭔가요?\"\n";
    static final String S1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static final String S2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static final String S3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    static final String ANSWER = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    static final String END = "라고 답변하였지.\n";

    static int N; // 재귀 횟수
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 재귀 횟수 입력
        N = Integer.parseInt(br.readLine());

        // 2. 인트로 포함 후 재귀 시작
        sb.append(INTRO);
        recur(0);

        // 3. 출력
        System.out.println(sb);
    }

    static void recur(int level) {
        // 들여쓰기 재정의
        String indent = INDENT.repeat(level); // repeat 기억하기

        // 전위: 질문은 항상 출력
        sb.append(indent).append(QUESTION);

        // base
        if (level == N) {
            sb.append(indent).append(ANSWER);
            sb.append(indent).append(END);
            return;
        }

        // 전위: 스토리 3줄
        sb.append(indent).append(S1);
        sb.append(indent).append(S2);
        sb.append(indent).append(S3);

        // 재귀
        recur(level + 1);

        // 후위: 클로징 멘트
        sb.append(indent).append(END);
    }

}
