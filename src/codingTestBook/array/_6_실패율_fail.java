package codingTestBook.array;

import java.util.*;

public class _6_실패율_fail {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        System.out.println(Arrays.toString(solution(N, stages)));
    }

    static int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>(); // stage-failRate

        // 1. 실패율 구하기
        for (int i = 1; i <= N; i++) {
            int unclear = 0; // i에서 멈춘 사람
            int tried = 0; // i에 도전한 사람
            for (int stage : stages) {
                if (stage == i) unclear++;
                if (stage >= i) tried++;
            }
            double rate = (tried == 0 ) ? 0.0 : (double) unclear / tried; // 포인트 1
            map.put(i, rate);
        }

        // 2. 실패율을 기준으로 스테이지 내림차순 정렬하기
        List<Integer> list = new ArrayList<>(map.keySet()); // 1-5
        list.sort((a,b) ->{
            int cmp = Double.compare(map.get(b), map.get(a)); // 실패율 내림차순
            return cmp == 0 ? Integer.compare(a, b) : cmp; // 동률 시 번호 오름차순 (포인트 2)
        });

        return list.stream().mapToInt(i -> i).toArray(); // 이거는 외우자! (포인트 3)
    }
}

/*
- 실패율: 스테이지 O + 클리어 X 플레이어 수 / 스테이지 O 플레이어 수
- 전체 스테이지 개수 N, 게임 이용 사용자가 멈춰있는 스테이지 번호 배열 stages
- 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨 있는 배열을 반환하는 solution 함수 완성하기
 */