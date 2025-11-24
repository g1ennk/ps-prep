# 바킹독 문제집 및 강의

## 기록 방법

### 🔢 LEVEL 기준 (숙련도 단계)

| LEVEL | 이름           | 의미            | 실제 상황 예시                        |
|:-----:|:-------------|---------------|---------------------------------|
|  `0`  | **UNSEEN**   | 아직 안 풀어봄      | 단순히 목록만 봤거나 클릭만 해봄              |
|  `1`  | **TRIED**    | 풀려고 했지만 실패    | 20–40분 고민했는데 AC가 안 나옴, 계속 WA/실패 |
|  `2`  | **HELPED**   | 해설 참고 후 해결    | 풀이/블로그/유튜브 도움으로 정답 이해           |
|  `3`  | **SOLVED**   | 혼자 해결, 하지만 불안 | 스스로 풀었지만 오래 걸림, 예외/실수 있었음       |
|  `4`  | **MASTERED** | 시간 재도 완벽      | 2–5분 내로 아이디어·구현 모두 매끄럽게 해결      |

> 💡 **LEVEL은 시간 + 이해도 기반!**  
> `TRIED → HELPED → SOLVED → MASTERED` 순으로 성장시켜 나가면 됨.

---

### 🏷 TAG 기준 (왜 어려웠는지 / 실패 요인 기록)

| TAG      | 의미         | 어떤 경우에 쓰나              |
|----------|------------|------------------------|
| `WA`     | 틀렸습니다      | 예제 맞는데 채점 틀림 / 조건 실수   |
| `TLE`    | 시간초과       | 알고리즘이 느림, N^2 이상 반복    |
| `IMPL`   | 구현 실수      | 오타, 초기화 빠짐, 조건문 오류     |
| `EDGE`   | 예외 처리 부족   | 0, 음수, 경계값, 빈 입력 처리 누락 |
| `IDEA`   | 아이디어/접근 실패 | 알고리즘 자체를 떠올리지 못함       |
| `SLOW`   | 시간이 오래 걸림  | 혼자 해결했지만 30분 이상 소요     |
| `REVIEW` | 재복습 필요     | 나중에 다시 보고 싶을 때 표시      |

> 🔎 **TAG는 여러 개 가능!**  
> 예: `IDEA, EDGE, REVIEW`

---

### 📝 예시 기록 (2309: 일곱 난쟁이)

```text
LEVEL: 2 (HELPED)
시도: 1
TAG: IDEA, REVIEW
메모: 두 사람을 고르는 브루트포스 발상을 못 떠올림.
```

## 오리엔테이션

- 강의 목표는 삼성전자 SW Test A형, B형 중간 수준의 코딩테스트를 통과하는 것
- 만약 시간이 정 시간이 없다면 그리디까지만 보고 문제 풀이에 집중
- 코테에 필요한 건 배경지식, 문제해결능력, 구현력

## 기초 코드 작성 요령 I

- 시간 복잡도: 입력의 크기와 문제를 해결하는데 걸리는 시간의 상관관계
    - 얼마나 오래 걸리는지를 측정
    - 입력 크기에 따라 연산 횟수가 얼마나 증가하는지를 표시
    - 빅오 표기법: 주어진 식을 값이 가장 큰 대표항만 남겨서 나타내는 방법

- 공간 복잡도: 입력의 크기와 문제를 해결하는데 필요한 공간의 상관관계
    - 알고리즘이 얼마만큼의 메모리를 사용하는지 측정

## 기초 코드 작성 요령 II

![100%](https://progress-bar.xyz/5?scale=27&title=progress&width=500&color=babaca&suffix=/27)

[문제집 링크](https://www.acmicpc.net/workbook/view/7306)

| 문제 분류  |  문제   |                        문제 제목                        |                                    정답 코드                                    | LEVEL | 시도 | TAG  | 메모 |
|:------:|:-----:|:---------------------------------------------------:|:---------------------------------------------------------------------------:|:-----:|:--:|:-----|:---|
| 연습 문제  | 10871 |  [X보다 작은 수](https://www.acmicpc.net/problem/10871)  |                    [정답 코드](../0x02/solutions/10871.cpp)                     |   4   | 2  | DONE |    |
| 기본 문제✔ | 1000  |     [A+B](https://www.acmicpc.net/problem/1000)     |                     [정답 코드](../0x02/solutions/1000.cpp)                     |   4   | 2  | DONE |    |
| 기본 문제✔ | 2557  | [Hello World](https://www.acmicpc.net/problem/2557) |                     [정답 코드](../0x02/solutions/2557.cpp)                     |   4   | 2  | DONE |    |
| 기본 문제✔ | 10171 |    [고양이](https://www.acmicpc.net/problem/10171)     |                    [정답 코드](../0x02/solutions/10171.cpp)                     |   4   | 2  | DONE |    |
| 기본 문제✔ | 10869 |    [사칙연산](https://www.acmicpc.net/problem/10869)    |                    [정답 코드](../0x02/solutions/10869.cpp)                     |   4   | 2  | DONE |    |
| 기본 문제✔ | 9498  |    [시험 성적](https://www.acmicpc.net/problem/9498)    |                     [정답 코드](../0x02/solutions/9498.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2752  |    [세수정렬](https://www.acmicpc.net/problem/2752)     |  [정답 코드](../0x02/solutions/2752.cpp), [별해 1](../0x02/solutions/2752_1.cpp)  |       |    |      |    |
| 기본 문제✔ | 2753  |     [윤년](https://www.acmicpc.net/problem/2753)      |                     [정답 코드](../0x02/solutions/2753.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2480  |   [주사위 세개](https://www.acmicpc.net/problem/2480)    |  [정답 코드](../0x02/solutions/2480.cpp), [별해 1](../0x02/solutions/2480_1.cpp)  |       |    |      |    |
| 기본 문제✔ | 2490  |     [윷놀이](https://www.acmicpc.net/problem/2490)     |                     [정답 코드](../0x02/solutions/2490.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2576  |     [홀수](https://www.acmicpc.net/problem/2576)      |                     [정답 코드](../0x02/solutions/2576.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2587  |    [대표값2](https://www.acmicpc.net/problem/2587)     |                     [정답 코드](../0x02/solutions/2587.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2309  |   [일곱 난쟁이](https://www.acmicpc.net/problem/2309)    |                     [정답 코드](../0x02/solutions/2309.cpp)                     |       |    |      |    |
| 기본 문제✔ | 10093 |     [숫자](https://www.acmicpc.net/problem/10093)     |                    [정답 코드](../0x02/solutions/10093.cpp)                     |       |    |      |    |
| 기본 문제✔ | 1267  |   [핸드폰 요금](https://www.acmicpc.net/problem/1267)    |                     [정답 코드](../0x02/solutions/1267.cpp)                     |       |    |      |    |
| 기본 문제✔ | 10804 |   [카드 역배치](https://www.acmicpc.net/problem/10804)   | [정답 코드](../0x02/solutions/10804.cpp), [별해 1](../0x02/solutions/10804_1.cpp) |       |    |      |    |
| 기본 문제✔ | 15552 |   [빠른 A+B](https://www.acmicpc.net/problem/15552)   |                    [정답 코드](../0x02/solutions/15552.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2438  |  [별 찍기 - 1](https://www.acmicpc.net/problem/2438)   |                     [정답 코드](../0x02/solutions/2438.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2439  |  [별 찍기 - 2](https://www.acmicpc.net/problem/2439)   |                     [정답 코드](../0x02/solutions/2439.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2440  |  [별 찍기 - 3](https://www.acmicpc.net/problem/2440)   |                     [정답 코드](../0x02/solutions/2440.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2441  |  [별 찍기 - 4](https://www.acmicpc.net/problem/2441)   |                     [정답 코드](../0x02/solutions/2441.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2442  |  [별 찍기 - 5](https://www.acmicpc.net/problem/2442)   |                     [정답 코드](../0x02/solutions/2442.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2443  |  [별 찍기 - 6](https://www.acmicpc.net/problem/2443)   |                     [정답 코드](../0x02/solutions/2443.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2444  |  [별 찍기 - 7](https://www.acmicpc.net/problem/2444)   |                     [정답 코드](../0x02/solutions/2444.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2445  |  [별 찍기 - 8](https://www.acmicpc.net/problem/2445)   |                     [정답 코드](../0x02/solutions/2445.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2446  |  [별 찍기 - 9](https://www.acmicpc.net/problem/2446)   |                     [정답 코드](../0x02/solutions/2446.cpp)                     |       |    |      |    |
| 기본 문제✔ | 2562  |     [최댓값](https://www.acmicpc.net/problem/2562)     |  [정답 코드](../0x02/solutions/2562.cpp), [별해 1](../0x02/solutions/2562_1.cpp)  |       |    |      |    |

## 배열

## 연결 리스트

## 스택

## 큐

## 덱

## 스택의 활용 (수식의 괄호 쌍)

## BFS

## DFS

## 재귀

## 백트래킹

## 시뮬레이션

![100%](https://progress-bar.xyz/0/?scale=61&title=progress&width=500&color=babaca&suffix=/61)

[문제집 링크](https://www.acmicpc.net/workbook/view/7316)

| 문제 분류  |  문제   |                              문제 제목                               |                                                       정답 코드                                                        | LEVEL | TRY | TAG | NOTE |
|:------:|:-----:|:----------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------:|-------|-----|-----|------|
| 연습 문제  | 15683 |           [감시](https://www.acmicpc.net/problem/15683)            |                                        [정답 코드](../0x0D/solutions/15683.cpp)                                        |       |     |     |      |
| 연습 문제  | 18808 |         [스티커 붙이기](https://www.acmicpc.net/problem/18808)         |                                        [정답 코드](../0x0D/solutions/18808.cpp)                                        |       |     |     |      |
| 연습 문제  | 12100 |       [2048 (Easy)](https://www.acmicpc.net/problem/12100)       |                                        [정답 코드](../0x0D/solutions/12100.cpp)                                        |       |     |     |      |
| 연습 문제  | 15686 |          [치킨 배달](https://www.acmicpc.net/problem/15686)          |                                        [정답 코드](../0x0D/solutions/15686.cpp)                                        |       |     |     |      |
| 기본 문제✔ | 11559 |        [Puyo Puyo](https://www.acmicpc.net/problem/11559)        |                                        [정답 코드](../0x0D/solutions/11559.cpp)                                        |       |     |     |      |
| 기본 문제✔ | 14891 |          [톱니바퀴](https://www.acmicpc.net/problem/14891)           |                                        [정답 코드](../0x0D/solutions/14891.cpp)                                        |       |     |     |      |
| 기본 문제✔ | 14499 |         [주사위 굴리기](https://www.acmicpc.net/problem/14499)         |                                        [정답 코드](../0x0D/solutions/14499.cpp)                                        |       |     |     |      |
| 기본 문제✔ | 13335 |           [트럭](https://www.acmicpc.net/problem/13335)            |                    [정답 코드](../0x0D/solutions/13335.cpp), [별해 1](../0x0D/solutions/13335_1.cpp)                     |       |     |     |      |
| 기본 문제✔ | 16985 |      [Maaaaaaaaaze](https://www.acmicpc.net/problem/16985)       |                                        [정답 코드](../0x0D/solutions/16985.cpp)                                        |       |     |     |      |
| 기본 문제✔ | 14503 |         [로봇 청소기](https://www.acmicpc.net/problem/14503)          |                                        [정답 코드](../0x0D/solutions/14503.cpp)                                        |       |     |     |      |
| 기본 문제✔ | 3190  |            [뱀](https://www.acmicpc.net/problem/3190)             |                                        [정답 코드](../0x0D/solutions/3190.cpp)                                         |       |     |     |      |
| 기본 문제✔ | 14500 |          [테트로미노](https://www.acmicpc.net/problem/14500)          | [정답 코드](../0x0D/solutions/14500.cpp), [별해 1](../0x0D/solutions/14500_1.cpp), [별해 2](../0x0D/solutions/14500_2.cpp) |       |     |     |      |
| 기본 문제✔ | 13460 |         [구슬 탈출 2](https://www.acmicpc.net/problem/13460)         |                                        [정답 코드](../0x0D/solutions/13460.cpp)                                        |       |     |     |      |
| 기본 문제✔ | 14502 |           [연구소](https://www.acmicpc.net/problem/14502)           | [정답 코드](../0x0D/solutions/14502.cpp), [별해 1](../0x0D/solutions/14502_1.cpp), [별해 2](../0x0D/solutions/14502_2.cpp) |       |     |     |      |
| 기본 문제✔ | 14888 |        [연산자 끼워넣기](https://www.acmicpc.net/problem/14888)         |                    [정답 코드](../0x0D/solutions/14888.cpp), [별해 1](../0x0D/solutions/14888_1.cpp)                     |       |     |     |      |
| 기본 문제✔ | 14889 |         [스타트와 링크](https://www.acmicpc.net/problem/14889)         |                                        [정답 코드](../0x0D/solutions/14889.cpp)                                        |       |     |     |      |
| 기본 문제✔ | 14890 |           [경사로](https://www.acmicpc.net/problem/14890)           |                                        [정답 코드](../0x0D/solutions/14890.cpp)                                        |       |     |     |      |
| 기본 문제✔ | 15684 |         [사다리 조작](https://www.acmicpc.net/problem/15684)          |                                        [정답 코드](../0x0D/solutions/15684.cpp)                                        |       |     |     |      |
| 기본 문제✔ | 15685 |         [드래곤 커브](https://www.acmicpc.net/problem/15685)          |                                        [정답 코드](../0x0D/solutions/15685.cpp)                                        |       |     |     |      |
| 기본 문제  | 17281 |            [⚾](https://www.acmicpc.net/problem/17281)            |                    [정답 코드](../0x0D/solutions/17281.cpp), [별해 1](../0x0D/solutions/17281_1.cpp)                     |       |     |     |      |
| 기본 문제  | 5373  |            [큐빙](https://www.acmicpc.net/problem/5373)            |                                        [정답 코드](../0x0D/solutions/5373.cpp)                                         |       |     |     |      |
| 기본 문제  | 16234 |          [인구 이동](https://www.acmicpc.net/problem/16234)          |                                        [정답 코드](../0x0D/solutions/16234.cpp)                                        |       |     |     |      |
| 기본 문제  | 16235 |         [나무 재테크](https://www.acmicpc.net/problem/16235)          |                                        [정답 코드](../0x0D/solutions/16235.cpp)                                        |       |     |     |      |
| 기본 문제  | 16236 |          [아기 상어](https://www.acmicpc.net/problem/16236)          |                                        [정답 코드](../0x0D/solutions/16236.cpp)                                        |       |     |     |      |
| 기본 문제  | 17140 |       [이차원 배열과 연산](https://www.acmicpc.net/problem/17140)        |                                        [정답 코드](../0x0D/solutions/17140.cpp)                                        |       |     |     |      |
| 기본 문제  | 17141 |          [연구소 2](https://www.acmicpc.net/problem/17141)          |                                        [정답 코드](../0x0D/solutions/17141.cpp)                                        |       |     |     |      |
| 기본 문제  | 17142 |          [연구소 3](https://www.acmicpc.net/problem/17142)          |                                        [정답 코드](../0x0D/solutions/17142.cpp)                                        |       |     |     |      |
| 기본 문제  | 17143 |           [낚시왕](https://www.acmicpc.net/problem/17143)           |                                        [정답 코드](../0x0D/solutions/17143.cpp)                                        |       |     |     |      |
| 기본 문제  | 17144 |        [미세먼지 안녕!](https://www.acmicpc.net/problem/17144)         |                                        [정답 코드](../0x0D/solutions/17144.cpp)                                        |       |     |     |      |
| 기본 문제  | 4991  |          [로봇 청소기](https://www.acmicpc.net/problem/4991)          |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 16986 |       [인싸들의 가위바위보](https://www.acmicpc.net/problem/16986)        |                                        [정답 코드](../0x0D/solutions/16986.cpp)                                        |       |     |     |      |
| 기본 문제  | 17779 |         [게리맨더링 2](https://www.acmicpc.net/problem/17779)         |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 17837 |        [새로운 게임 2](https://www.acmicpc.net/problem/17837)         |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 17822 |         [원판 돌리기](https://www.acmicpc.net/problem/17822)          |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 17825 |         [주사위 윷놀이](https://www.acmicpc.net/problem/17825)         |                                        [정답 코드](../0x0D/solutions/17825.cpp)                                        |       |     |     |      |
| 기본 문제  | 19235 |         [모노미노도미노](https://www.acmicpc.net/problem/19235)         |                                        [정답 코드](../0x0D/solutions/19235.cpp)                                        |       |     |     |      |
| 기본 문제  | 20061 |        [모노미노도미노 2](https://www.acmicpc.net/problem/20061)        |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 19236 |         [청소년 상어](https://www.acmicpc.net/problem/19236)          |                                        [정답 코드](../0x0D/solutions/19236.cpp)                                        |       |     |     |      |
| 기본 문제  | 19237 |          [어른 상어](https://www.acmicpc.net/problem/19237)          |                                        [정답 코드](../0x0D/solutions/19237.cpp)                                        |       |     |     |      |
| 기본 문제  | 19238 |         [스타트 택시](https://www.acmicpc.net/problem/19238)          |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 20055 |      [컨베이어 벨트 위의 로봇](https://www.acmicpc.net/problem/20055)      |                                        [정답 코드](../0x0D/solutions/20055.cpp)                                        |       |     |     |      |
| 기본 문제  | 20056 |      [마법사 상어와 파이어볼](https://www.acmicpc.net/problem/20056)       |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 20057 |      [마법사 상어와 토네이도](https://www.acmicpc.net/problem/20057)       |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 20058 |      [마법사 상어와 파이어스톰](https://www.acmicpc.net/problem/20058)      |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 16637 |         [괄호 추가하기](https://www.acmicpc.net/problem/16637)         |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 17070 |        [파이프 옮기기 1](https://www.acmicpc.net/problem/17070)        |                    [정답 코드](../0x0D/solutions/17070.cpp), [별해 1](../0x0D/solutions/17070_1.cpp)                     |       |     |     |      |
| 기본 문제  | 17135 |         [캐슬 디펜스](https://www.acmicpc.net/problem/17135)          |                                        [정답 코드](../0x0D/solutions/17135.cpp)                                        |       |     |     |      |
| 기본 문제  | 17136 |         [색종이 붙이기](https://www.acmicpc.net/problem/17136)         |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 17406 |        [배열 돌리기 4](https://www.acmicpc.net/problem/17406)         |                                        [정답 코드](../0x0D/solutions/17406.cpp)                                        |       |     |     |      |
| 기본 문제  | 17471 |          [게리맨더링](https://www.acmicpc.net/problem/17471)          |                                        [정답 코드](../0x0D/solutions/17471.cpp)                                        |       |     |     |      |
| 기본 문제  | 17472 |        [다리 만들기 2](https://www.acmicpc.net/problem/17472)         |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 15898 | [피아의 아틀리에 ~신비한 대회의 연금술사~](https://www.acmicpc.net/problem/15898) |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 21608 |         [상어 초등학교](https://www.acmicpc.net/problem/21608)         |                                        [정답 코드](../0x0D/solutions/21608.cpp)                                        |       |     |     |      |
| 기본 문제  | 21609 |         [상어 중학교](https://www.acmicpc.net/problem/21609)          |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 21610 |      [마법사 상어와 비바라기](https://www.acmicpc.net/problem/21610)       |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 21611 |      [마법사 상어와 블리자드](https://www.acmicpc.net/problem/21611)       |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 23288 |        [주사위 굴리기 2](https://www.acmicpc.net/problem/23288)        |                                        [정답 코드](../0x0D/solutions/23288.cpp)                                        |       |     |     |      |
| 기본 문제  | 23289 |         [온풍기 안녕!](https://www.acmicpc.net/problem/23289)         |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 23290 |       [마법사 상어와 복제](https://www.acmicpc.net/problem/23290)        |                                        [정답 코드](../0x0D/solutions/23290.cpp)                                        |       |     |     |      |
| 기본 문제  | 23291 |          [어항 정리](https://www.acmicpc.net/problem/23291)          |                                                         -                                                          |       |     |     |      |
| 기본 문제  | 2478  |           [자물쇠](https://www.acmicpc.net/problem/2478)            |                                                         -                                                          |       |     |     |      |

## 정렬 I

## 정렬 II

## 다이나믹 프로그래밍

## 그리디

## 수학

## 이분탐색

## 투 포인터

## 해시

## 이진 검색 트리

## 우선순위 큐

## 그래프

## 트리

## 위상 정렬

## 최소 신장 트리

## 플로이드 알고리즘

## KMP

## 트라이

## 문자열 기초

## 동적 배열

## 비트마스킹

## Union-Find