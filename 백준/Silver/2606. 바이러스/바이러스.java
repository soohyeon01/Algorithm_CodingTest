import java.io.*;
import java.util.*;

/**
 * 그래프 탐색
 */
public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cnt_dfs = 0;
//    static int cnt_bfs = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수(node)
        int connect = Integer.parseInt(br.readLine()); // 연결의 수(edge)

        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < connect; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n + 1];
        dfs(1);

        System.out.println(cnt_dfs - 1); // 1을 제외한 노드의 개수를 구해야함

/*
        visited = new boolean[n + 1];
        visited[1] = true;
        bfs(1);
        System.out.println(cnt_bfs-1);
*/

    }

    private static void dfs(int node) {
        visited[node] = true;
        cnt_dfs++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }

    }
/*
    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty()) {
            int node = q.poll();
            cnt_bfs++;

            for (int next : graph[node]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
*/
}
