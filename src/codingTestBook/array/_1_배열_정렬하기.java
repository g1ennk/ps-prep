package codingTestBook.array;

import java.util.Arrays;

public class _1_배열_정렬하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution1(new int[]{2, 1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(solution1(new int[]{6, 1, 7})));
    }

    // 원본 정렬
    static int[] solution1(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    // 원본 유지
    static int[] solution2(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        return clone;
    }
}
