package barkingDog.x06_advanced_data_structures.x15_hash.level1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬마스터이다솜 {


    static int N; // 포켓몬의 개수
    static int M; // 내가 맞춰야 하는 문제의 개수
    static Map<Integer, String> numberMap = new HashMap<>();
    static Map<String, Integer> nameMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N,M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2. 포켓몬 N만큼 입력
        for (int i = 1; i <= N; i++) {
            String pokemonName = br.readLine();
            numberMap.put(i, pokemonName);
            nameMap.put(pokemonName, i);
        }

        // 3. 문제 M 입력
        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            // 번호인 경우
            if (Character.isDigit(input.charAt(0))) {
                String pokemonName = numberMap.get(Integer.parseInt(input));
                bw.write(pokemonName + "\n");
            }
            // 이름인 경우
            else {
                int number = nameMap.get(input);
                bw.write(number + "\n");
            }
        }

        // 4. 최종 출력
        bw.flush();
    }
}
