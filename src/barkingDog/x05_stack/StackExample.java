package barkingDog.x05_stack;

import java.util.ArrayDeque;

public class StackExample {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(1); // 1
        stack.push(2); // 2

        int top = stack.peek(); // 2
        int pop = stack.pop(); // 2

        System.out.println("top = " + top); // 2
        System.out.println("pop = " + pop); // 1
        System.out.println(stack.size()); // 1
    }
}
