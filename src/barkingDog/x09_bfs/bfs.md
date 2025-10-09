# BFS

- BFS(Breadth First Search)
    - 다차원 배열에서 각 칸을 방문할 때 너비를 우선으로 방문하는 알고리즘
- 동작 과정
    1. 시작하는 칸을 큐에 넣고 방문 처리
    2. 큐가 빌 때까지 다음을 반복:
        - 큐에서 현재 칸을 꺼냄
        - 상하좌우(혹은 인접 노드) 탐색
            - 이미 방문했다면 → continue
            - 처음 방문한 칸이라면 → 방문 처리 후 큐에 삽입
- 템플릿
    ```java
    import java.util.ArrayDeque;
    
    // 1. 전역 변수 및 상주 정의
    static int N, M; // 격자 크기
    static int[][] board; // 2차원 배열 격자
    static boolean[][] visited; // 방문 여부 체크
    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 4방향 탐색 (상하좌우)
    
    // 2. BFS 기본 구조
    static void bfs(int sr, int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        // 시작점 초기화
        visited[sr][sc] = true;
        q.offer(new int[]{sr, sc});
        
        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            // 4방향 탐색
            for (int[] d : DIR) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                // 1) 범위 확인
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                // 2) 방문 여부 확인
                if (visited[nr][nc]) continue;
                // 3) 통과 가능한지 확인
                if (board[nr][nc] != 1) continue;
                
                // 방문 처리 및 큐 삽입
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
    }
    ```

- 응용
    - 거리 측정: BOJ 2178 미로 탐색
    - 시작점이 여러 개일 때: BOJ 7576 토마토
      - 시작점을 큐에 다 넣자
- 주의
    - r,c 입력 순서 확실하게 보기