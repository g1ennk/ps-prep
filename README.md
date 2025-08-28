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

## 바킹독 강의

### 0x00강 - 오리엔테이션

- 대상: 언어는 알지만 자료구조 및 알고리즘이 약한 취준생/학부생/비전공자
- 학습 전략: 0x11 그리디까지는 무조건 필수
- 필요한 능력
    - 배경지식: 강의, 교재 등을 통해 기본 개념 학습
    - 문제해결능력: 다양한 문제를 접해봐야 함.
    - 구현력: 많이 접하는 것 뿐만 아니라 다른 사람들의 코드도 참고하면 좋음.

### 0x01강 - 기초 코드 작성 요령

- 시간 복잡도: 입력의 크기와 문제를 해결하는데 걸리는 시간의 상관관계
    - n에 비례한다.
    - 빅오표기법: 주어진 식을 값이 가장 큰 대표항만 남겨서 나타내는 방법
    - 즉, 문제를 보고 바로 들어가는 것이 아닌 시간 복잡도를 생각하고 그거에 맞는 풀이를 떠올려야 한다.
- 공간 복잡도: 입력의 크기와 문제를 해결하는데 필요한 공간의 상관관계
    - 512MB = 1.2억개의 int
- 정수 자료형
- 실수 자료형