## ps-prep

이 저장소는 코딩테스트 문제 풀이를 정리한 레포지토리입니다.

---

### 입출력 템플릿 규칙

- 항상 초기 선언
  ```java
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  ```

- 필요할 때만 선언 및 초기화
    ```java
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    ```
- 출력 규칙
  ```java
  // 한 줄 출력
  bw.write();
  
  // 여러 줄 출력 시 StringBuilder 활용
  bw.write(sb.toString());
  ```

---

### 커밋 컨벤션

- `날짜: 문제(태그)` ex) `20250820: 1000[AC], 10871[AC], 2557[AC]`
- 태그 설명
    - [AC] = Accepted (맞았습니다)
    - [WA] = Wrong Answer (틀렸습니다)
    - [TLE] = Time Limit Exceeded
    - [RE] = Runtime Error
    - [MLE] = Memory Limit Exceeded

---