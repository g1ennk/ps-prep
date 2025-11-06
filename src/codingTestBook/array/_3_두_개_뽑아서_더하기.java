package codingTestBook.array;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class _3_두_개_뽑아서_더하기 {
    public static void main(String[] args) {
        int[] numbers1 = {2, 1, 3, 4, 1};
        int[] numbers2 = {5, 0, 2, 7};

        System.out.println(Arrays.toString(solution(numbers1)));
        System.out.println(Arrays.toString(solution(numbers2)));
    }

    // 서로 다른 두 개의 수를 뽑아 더해 만들 수 있는 모든 수를 오름차순 정렬
    static int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        // 두 개 뽑아서 더한 후 Set에 추가
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // Set을 배열로 변환
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            result[i++] = integer;
        }

        return result;
    }
}
