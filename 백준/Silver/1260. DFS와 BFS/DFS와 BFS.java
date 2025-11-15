import java.io.*;
import java.util.*;

/**
 *  그래프 탐색/ DFS와 BFS
 */
public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 정점의 개수
        int m = Integer.parseInt(st.nextToken());   // 간선의 개수
        int v = Integer.parseInt(st.nextToken());   // 시작할 정점의 번호

        // 그래프 초기화 - 연결리스트로 구현
        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 방문할 수 있는 정점이 여러개인 경우 작은 것 먼저 방문 - 각 정점 별 정렬 필요
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        //dfs
        visited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");

        //bfs
        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }

        }
    }

}