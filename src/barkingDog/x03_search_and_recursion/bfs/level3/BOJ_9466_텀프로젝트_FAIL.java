package barkingDog.x03_search_and_recursion.bfs.level3;

import java.io.*;
import java.util.StringTokenizer;

// 텀 프로젝트(TRY:1)
public class BOJ_9466_텀프로젝트_FAIL {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 T 입력
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 1.1. 학생의 수 n 입력
            int n = Integer.parseInt(br.readLine());
            int[] students = new int[n + 1]; // 배열 1부터 시작하도록

            // 1.2. 학생들의 번호 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            // 1.3. 프로젝트에 속하지 않는 학생들의 수 계산
            bw.write(solution(n, students) + "\n");
        }

        // 2. 출력
        bw.flush();
    }

    public static int solution(int n, int[] students) {
        // 1-based 인덱스이기 때문에 n+1
        boolean[] visited = new boolean[n + 1];
        boolean[] finished = new boolean[n + 1];
        int teamMemberCount = 0;

        // 1번 학생부터 n번까지 DFS 시도
        for (int student = 1; student <= n; student++) {
            if (!visited[student]) {
                teamMemberCount += dfs(students, visited, finished, student);
            }
        }

        // 팀에 속하지 않은 학생 수 = 전체 학생 수 - 팀 학생 수
        return n - teamMemberCount;
    }

    private static int dfs(int[] students, boolean[] visited, boolean[] finished, int student) {
        // 초기 방문 처리
        visited[student] = true;
        int nextStudent = students[student];
        int cycleSize = 0;

        // 아직 방문하지 않은 학생이면 다음 학생 계속 탐색
        if (!visited[nextStudent]) {
            cycleSize += dfs(students, visited, finished, nextStudent);
        }
        // 방문은 했는데 아직 finished가 아니면 -> 현재 DFS 경로 안 사이클 발견
        else if (!finished[nextStudent]) {
            int count = 1; // nextStudent 자기 자신부터 카운트
            int cur = students[nextStudent];

            while (cur != nextStudent) {
                count++;
                cur = students[cur];
            }

            cycleSize += count;
        }

        // 끝까지 도달
        finished[student] = true;
        return cycleSize;
    }

}

/* 메모
- 프로젝트 팀원 수에는 제한이 없다. 모든 학생들이 한 팀을 이뤄 한 팀만 있을 수도 있다.
- 같이 프로젝트를 하고 싶은 학생들을 선택해야 한다(한 명당 한 명씩 + 자기 자신만 선택하는 것도 가능)
- 예를 들어 한 반에 7명이 있다.

1 cur -> 1 visited -> 3 next -> 1 finished
2 cur -> 2 visited -> 1 next -> 1은 이미 visited && finished -> 2 finished
3 cur -> 3 visited -> 3 next -> cycleSize = 1 -> 3 finished -> teamMemberCount = 1
4 cur -> 4 visited -> 7 next -> co
5
6 cur -> 6 visited -> 4 next
7 cur -> 7 visited -> 6 next
*/