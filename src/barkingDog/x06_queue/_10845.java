package barkingDog.x06_queue;

import java.io.*;

// 10845: 큐: 선형 큐로 구현
public class _10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 초기화
        int N = Integer.parseInt(br.readLine());
        int[] queue = new int[N];
        int head = 0, tail = -1, size = 0;
        StringBuilder sb = new StringBuilder();

        // 2. N개의 명령 처리
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();

            // push X: 큐의 맨 뒤에 원소 삽입
            if (cmd.startsWith("push")) {
                int data = Integer.parseInt(cmd.split(" ")[1]);
                queue[++tail] = data; // tail을 먼저 하나 늘린 후, 그 자리에 값 추가
                size++;
            }
            // pop: 큐의 맨 앞 원소를 빼고 출력 (없으면 -1)
            else if (cmd.equals("pop")) {
                if (size == 0) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(queue[head]).append("\n");
                head++; // head 한 칸 이동
                size--;
            }
            // size: 큐에 들어 있는 원소 개수 출력
            else if (cmd.equals("size")) {
                sb.append(size).append("\n");
            }
            // empty: 큐가 비어있으면 1, 아니면 0 출력
            else if (cmd.equals("empty")) {
                sb.append((size == 0) ? "1\n" : "0\n");
            }
            // front: 큐 맨 앞 원소 출력 (없으면 -1)
            else if (cmd.equals("front")) {
                if (size == 0) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(queue[head]).append("\n");
            }
            // back: 큐의 맨 뒤 원소 출력 (없으면 -1)
            else if (cmd.equals("back")) {
                if (size == 0) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(queue[tail]).append("\n");
            }
        }

        // 3. 결과 출력
        bw.write(sb.toString());
        bw.flush();
    }
}