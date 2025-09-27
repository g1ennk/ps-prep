## Stack

### 자료구조 및 알고리즘 관점

---

- 핵심: `LIFO(Last-In, First-Out) 자료구조: 나중에 넣은 게 먼저 나온다.`
- 연산
    - `push(x)`, `pop()`, `peek()`, `isEmpty()`, `size()`
    - 평균 시간복잡도: O(1)
- 구현 방식
    - 배열 기반(동적 크기 확장): 캐시 친화적 및 구현 간단
    - 연결리스트 기반: 삽입 삭제 O(1)이지만 포인터 오버헤드
- 자바에선?
    - Stack 대신 Deque의 ArrayDeque를 스택처럼 사용(가볍고, 빠르고, 동기화 비용 없음)
    - Stack은 레거시 + 불필요한 동기화로 코테 및 실무에선 비추
- 팁
    - ArrayDeque는 null 저장 불가
    - 빈 스택에서 pop 및 peek은 isEmpty 먼저 체크

### 코딩테스트 관점: 직전 상태를 되돌아봐야 할 때 (문제 풀면서)

---

### 체크리스트

---

- 자바에선 `Stack` 대신 `Deque<ArrayDeque>`를 사용하자!
- 빈 스택에선 곧바로 `peek`, `pop` 금지, `isEmpty`로 검증
- `ArrayDeque` 에선 `null` 금지