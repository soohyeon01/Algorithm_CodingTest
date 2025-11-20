import java.io.*;
import java.util.*;

/**
 * 11724
 * 방향 없는 그래프, 연결 요소의 개수 구하기
 * 그래프 탐색
 */
public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드
        int m = Integer.parseInt(st.nextToken()); // 간선

        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    private static void dfs(int i) {
        visited[i] = true;

        for (int next : graph[i]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
