package codingTestBook.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class _2_배열_제어하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }

    // 중복 제거 + 내림차순 정렬 -> TreeSet!
    public static int[] solution(int[] arr) {
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        // 1. Set에 추가: 중복 제거 + 내림차순 정렬
        for (Integer integer : arr) {
            set.add(integer);
        }

        // 2. Set -> Array 변환
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            result[i++] = integer;
        }

        return result;
    }
}
