import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 그래프 탐색(DFS, BFS)
 * 해당 문제는 재귀를 사용한 DFS로 풀이
 */
public class Main {

    static int m, n, k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());    // 테스트 케이스의 수

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());   // 가로
            n = Integer.parseInt(st.nextToken());   // 세로
            k = Integer.parseInt(st.nextToken());   // 배추 개수

            map = new int[n][m];    // 배추 심기; map[y][x]
            visited = new boolean[n][m];  // 방문 판별

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
/* 디버깅 코드
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(map[i][j] +" ");
                }
                System.out.println();
            }
*/
            int worm = 0;   // 지렁이 몇마리
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (map[y][x] == 1 && !visited[y][x]) {
                        dfs(y, x);
                        worm++;
                    }
                }
            }
            sb.append(worm).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }
}