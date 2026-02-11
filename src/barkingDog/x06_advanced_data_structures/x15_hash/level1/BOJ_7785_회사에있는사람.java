package barkingDog.x06_advanced_data_structures.x15_hash.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7785_회사에있는사람 {

    static final String ENTER = "enter";
    static final String LEAVE = "leave";

    static Set<String> records = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 출입 기록의 수 n 입력
        int n = Integer.parseInt(br.readLine());

        // 2. 출입 기록 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            record(name, action);
        }

        // 3. 역순으로 이름 출력
        printNameInReverseOrder();
    }

    private static void record(String name, String action) {
        if (action.equals(ENTER)) {
            records.add(name);
        } else if (action.equals(LEAVE)) {
            records.remove(name);
        }
    }

    private static void printNameInReverseOrder() {
        List<String> list = new ArrayList<>(records);
        list.sort(Collections.reverseOrder());
        for (String name : list) {
            System.out.println(name);
        }
    }


}
