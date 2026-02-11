package barkingDog.x06_advanced_data_structures.x15_hash;

import java.util.ArrayList;

public class HashMapChaining {

    private static final int SIZE = 10003; // 소수
    private ArrayList<Node>[] table;

    static class Node {
        String key;
        int value;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMapChaining() {
        table = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new ArrayList<>();
        }
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // 삽입, 갱신
    public void put(String key, int value) {
        int idx = hash(key);
        for (Node node : table[idx]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        table[idx].add(new Node(key, value));
    }

    // 조회
    public Integer get(String key) {
        int idx = hash(key);
        for (Node node : table[idx]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    // 삭제
    public void remove(String key) {
        int idx = hash(key);
        table[idx].removeIf(node -> node.key.equals(key));
    }

    public static void main(String[] args) {
        HashMapChaining map = new HashMapChaining();

        // 1. 삽입 테스트
        map.put("apple", 100);
        map.put("banana", 200);
        map.put("orange", 300);

        System.out.println("apple = " + map.get("apple"));   // 100
        System.out.println("banana = " + map.get("banana")); // 200
        System.out.println("orange = " + map.get("orange")); // 300

        // 2. 갱신 테스트
        map.put("apple", 999);
        System.out.println("apple(after update) = " + map.get("apple")); // 999

        // 3. 없는 키 조회
        System.out.println("grape = " + map.get("grape")); // null

        // 4. 삭제 테스트
        map.remove("banana");
        System.out.println("banana(after remove) = " + map.get("banana")); // null

        // 5. 충돌 테스트 (강제로 비슷한 키들)
        map.put("Aa", 1);
        map.put("BB", 2); // "Aa".hashCode() == "BB".hashCode()

        System.out.println("Aa = " + map.get("Aa")); // 1
        System.out.println("BB = " + map.get("BB")); // 2

        map.remove("Aa");
        System.out.println("Aa(after remove) = " + map.get("Aa")); // null
        System.out.println("BB(still exists) = " + map.get("BB")); // 2

        System.out.println("=== TEST END ===");
    }


}
