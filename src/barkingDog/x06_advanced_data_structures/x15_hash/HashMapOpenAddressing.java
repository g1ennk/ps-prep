package barkingDog.x06_advanced_data_structures.x15_hash;

public class HashMapOpenAddressing {

    private static final int SIZE = 10007; // 소수
    private static final int EMPTY = 0;
    private static final int OCCUPIED = 1;
    private static final int DELETED = 2;

    private String[] keys;
    private int[] values;
    private int[] states;

    public HashMapOpenAddressing() {
        this.keys = new String[SIZE];
        this.values = new int[SIZE];
        this.states = new int[SIZE];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // 삽입, 갱신
    public void put(String key, int value) {
        int idx = hash(key);

        while (states[idx] == OCCUPIED) {
            if (keys[idx].equals(key)) {
                values[idx] = value; // 갱신
                return;
            }
            idx = (idx + 1) % SIZE;
        }

        keys[idx] = key;
        values[idx] = value;
        states[idx] = OCCUPIED;
    }

    // 조회
    public Integer get(String key) {
        int idx = hash(key);

        while (states[idx] != EMPTY) {
            if (states[idx] == OCCUPIED && keys[idx].equals(key)) {
                return values[idx];
            }
            idx = (idx + 1) % SIZE;
        }
        return null;
    }

    // 삭제
    public void remove(String key) {
        int idx = hash(key);

        while (states[idx] != EMPTY) {
            if (states[idx] == OCCUPIED && keys[idx].equals(key)) {
                states[idx] = DELETED;
                return;
            }
            idx = (idx + 1) % SIZE;
        }
    }

    public static void main(String[] args) {
        HashMapOpenAddressing map = new HashMapOpenAddressing();

        // 1. 삽입
        map.put("apple", 100);
        map.put("banana", 200);
        map.put("orange", 300);

        System.out.println("apple = " + map.get("apple"));   // 100
        System.out.println("banana = " + map.get("banana")); // 200
        System.out.println("orange = " + map.get("orange")); // 300

        // 2. 갱신
        map.put("apple", 999);
        System.out.println("apple(after update) = " + map.get("apple")); // 999

        // 3. 삭제
        map.remove("banana");
        System.out.println("banana(after remove) = " + map.get("banana")); // null

        // 4. 충돌 테스트
        map.put("Aa", 1);
        map.put("BB", 2); // hashCode 충돌

        System.out.println("Aa = " + map.get("Aa")); // 1
        System.out.println("BB = " + map.get("BB")); // 2

        map.remove("Aa");
        System.out.println("Aa(after remove) = " + map.get("Aa")); // null
        System.out.println("BB(still exists) = " + map.get("BB")); // 2

        System.out.println("=== TEST END ===");
    }

}
