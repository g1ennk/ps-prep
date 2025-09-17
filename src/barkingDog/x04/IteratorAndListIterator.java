package barkingDog.x04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IteratorAndListIterator {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>(Arrays.asList("A", "B", "C"));

        ListIterator<String> it = names.listIterator();
        System.out.println(names);

        // 순방향 출력
        while (it.hasNext()) {
            System.out.println("Next: " + it.next());
        }

        // 역방향 출력
        while (it.hasPrevious()) {
            System.out.println("Previous: " + it.previous());
        }

        // 중간 원소 삽입
        it = names.listIterator(1); // B 위치
        it.add("Z"); // A Z B C
        System.out.println(names);

        // 수정
        it.next(); // B
        it.set("Y"); // A Z Y C
        it.next(); // Y
        it.remove(); // C 제거 -> A Z Y
        System.out.println(names);
    }
}
