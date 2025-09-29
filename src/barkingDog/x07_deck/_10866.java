package barkingDog.x07_deck;

import java.io.*;
import java.util.StringTokenizer;

// 10866: 덱
public class _10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 명령의 수 N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 2. 초기화
        int[] deck = new int[2 * N];
        int head = N;
        int tail = N - 1;
        int size = 0;

        // 3. 명령어 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            // push front x
            if (command.equals("push_front")) {
                deck[--head] = Integer.parseInt(st.nextToken());
                size++;
            }
            // push back x
            else if (command.equals("push_back")) {
                deck[++tail] = Integer.parseInt(st.nextToken());
                size++;
            }
            // pop front
            else if (command.equals("pop_front")) {
                if (size == 0) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deck[head++]).append("\n");
                size--;
            }
            // pop back
            else if (command.equals("pop_back")) {
                if (size == 0) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deck[tail--]).append("\n");
                size--;
            }
            // size
            else if (command.equals("size")) {
                sb.append(size).append("\n");
            }
            // empty(비어있으면 1, 아니면 0)
            else if (command.equals("empty")) {
                sb.append((size == 0) ? "1" : "0").append("\n");
            }
            // front (비어있는경우 -1)
            else if (command.equals("front")) {
                if (size == 0) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deck[head]).append("\n");
            }
            // back (비어있는경우 -1)
            else if (command.equals("back")) {
                if (size == 0) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deck[tail]).append("\n");
            }

        }

        // 4. 출력
        bw.write(sb.toString());
        bw.flush();
    }
}
