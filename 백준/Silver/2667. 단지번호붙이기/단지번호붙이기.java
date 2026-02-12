import java.io.*;
import java.util.*;

/**
 * 2667 - 단지에 번호 붙이기 (그래프 탐색)
 * 0 과 1로 표시된 지도를 입력받고, 총 단지수와 각 단지내의 집의 수를 오름차순으로 정렬
 * BFS를 돌릴 때마다 새로운 큐를 사용해야하고, 여러번 BFS를 실행해야 함.
 */

public class Main {

    static int N; // 지도 한 변의 크기
    static int[][] map;
    static boolean[][] visited;
    static int cnt; // 단지내 집의 수
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> result = new ArrayList<>(); // 추후 오름차순으로 정리해야하기 때문에 편리성을 위해 리스트에 집의 수 저장

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    bfs(i, j);
                    result.add(cnt);
                }
            }
        }

        Collections.sort(result); // 리스트 오름차순 정렬
        System.out.println(result.size()); // 첫줄은 총 단지수 출력
        for (Integer i : result) { // 두번째 줄부터 각 단지의 집 수 출력
            System.out.println(i);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>(); // 새로운 단지를 만날 때마다 집의 수가 초기화 되어야하므로 큐를 bfs내에서 새로 생성
        q.add(new int[]{x, y}); // 방문해야할 점을 큐에 저장
        visited[x][y] = true; // 방문확인 
        cnt++;  // 집의 수 증가

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            // 이동범위
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 범위 체크

                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
    }
}

