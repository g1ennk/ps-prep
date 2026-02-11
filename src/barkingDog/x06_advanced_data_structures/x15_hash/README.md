# Hash

## 1. 정의와 성질

- 해시 자료구조는 키에 대응되는 값을 저장하는 자료구조
- 해시는 insert, delete, find, update 모두 O(1)
- 해시 함수는 임의 길이의 데이터를 고정된 길이의 데이터로 대응시키는 함수
- 충돌이란, 서로 다른 키가 같은 해시 값을 가지게 되는 것

## 2. 충돌 회피 1 - Chaining

- 연결 리스트를 활용한 순회
- 이상적인 상황에선 O(1)이지만, 충돌이 빈번할수록 성능이 저하되고, 모든 키의 해시 값이 같은 최악의 상황에선 O(N)이 됨
- 따라서 성능을 위핸선 해시 값이 최대한 균등하게 퍼져야 하고, 그러기 위해선 주어진 데이터에 대한 좋은 해시 함수를 정해야 함

## 3. 충돌 회피 2 - Open addressing

- 배열의 다음 칸을 활용한다?
- 땡기거나 밀어야? 아님 더미 값을 추가해야
- Linear Probing = 충돌 발생 시 오른쪽으로 1칸씩 이동하는 방식
    - 장점 - Cache hit rate가 높다
    - 단점 - Clustering이 생겨 성능에 영향을 줄 수 있다.
- Quadratic Probing = 충돌 발생 시 오른쪽으로 1,3,5, .. 칸씩 이동하는 방식
    - 장점 - Cache hit rate가 나쁘지 않고, Clustering을 어느 정도 회피할 수 있다.
- Double Hashing = 충돌 발생 시 이동할 칸의 수를 새로운 해시 함수로 계산하는 방식
    - 장점 - Clustering을 효과적으로 회피할 수 있다.
    - 단점 - Cache hit rate가 낮다.

## 4. Java

- HashSet
    - 중복 불가
    - 존재 확인 / 삽입 / 삭제가 핵심
        ```java 
           public static void main(String[] args) {
               Set<String> set = new HashMap<>();
               set.add("Kim");         // insert
               set.remove("Kim");      // erase
               set.contains("Kim");    // find
               set.size();             // size
           }
          
       ```

- HashMap
    - 키 -> 값 매핑
    - 평균 O(1)로 조회/삽입/삭제
      ```java
      
      public static void main(String[] args) {
          Map<String, Integer> map = new HashMap<>();
      
          map.put("hi", 123);              // insert/update
          map.put("hi", -7);               // overwrite (덮어쓰기)
          map.containsKey("hi");           // find 여부
          int v = map.get("hi");           // 조회 (없으면 null)
          map.remove("hi");                // erase
          map.size();
      
      }
      
      ```

## 5. 연습 문제 2문제

## 6. 구현 (chaining, open addressing)