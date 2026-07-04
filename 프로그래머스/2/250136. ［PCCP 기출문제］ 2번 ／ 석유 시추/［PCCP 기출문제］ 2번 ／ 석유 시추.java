import java.util.*;

class Solution {

    static ArrayList<Integer>[] graph;
    static boolean[][] visited;
    static Set<Integer> cols;
    static int size; // 석유 덩어리의 크기
    static int n, m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public int solution(int[][] land) {
        int answer = 0;

        n = land.length; // 시추관이 들어가는 길이
        m = land[0].length; // 시추관을 넣을 수 있는 열의 수
        visited = new boolean[n][m];

        // 해당 덩어리의 크기와 어느 열에서 시추할 수 있는지 저장
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    size = 0;
                    bfs(land, i, j);

                    for (int col : cols) {
                        map.put(col, map.getOrDefault(col, 0) + size);
                        answer = Math.max(answer, map.get(col));
                    }
                }

            }
        }

        return answer;
    }

    private void bfs(int[][] land, int i, int j) {
        Queue<int[]> q = new LinkedList<>(); // 새로운 덩어리를 만나면 새로운 큐를 만들어야 함
        cols = new HashSet<>(); // 석유를 시추할 수 있는 열을 저장

        q.add(new int[]{i, j});
        visited[i][j] = true; // 방문 체크
        cols.add(j);
        size++; // 덩어리의 크기 증가

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            // 이동 범위 설정 - 가로로 이동하면 시추할 수 있는 열에 해당 덩어리를 추가
            // k 가 2 와 3 일때, 같은 칸에 포함된다면 시추할 수 있는 열을 추가하여 그 번호에 + size
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (land[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    cols.add(ny);
                    size++;
                }

            }
        }
    }

}