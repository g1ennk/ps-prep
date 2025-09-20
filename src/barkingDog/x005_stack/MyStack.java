package barkingDog.x005_stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStack {

    private int[] stack = new int[10];
    private int top = -1;

    public void push(int x) {
        if (top + 1 == stack.length) {
            stack = Arrays.copyOf(stack, stack.length << 1);
        }
        stack[++top] = x;
    }

    public int pop() {
        if (top == -1) throw new NoSuchElementException();
        return stack[top--];
    }

    public int peek() {
        if (top == -1) throw new NoSuchElementException();
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        System.out.println("Push");
        System.out.println("-----");
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println("현재 사이즈: " + myStack.size());
        System.out.println();

        // 하나씩 빼기
        System.out.println("Pop");
        System.out.println("-----");
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
        System.out.println();

        System.out.println("isEmpty");
        System.out.println("-----");
        System.out.println(myStack.isEmpty());

    }
}
