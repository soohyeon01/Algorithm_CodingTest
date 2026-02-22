import java.io.*;
import java.util.*;

/**
 * 1389 - 케빈 베이컨의 6단계 법칙(BFS)
 * 모든 사람은 친구관계로 연결되어있음, 케빈베이컨의 수가 가장 작은 사람을 출력, 그런 사람이 여러명일 경우 번호가 가장 작은 사람을 출력
 */

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph; // 친구 관계 저장(정적 데이터)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 유저의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        // 그래프 초기화
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프에 관계 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int minSum = Integer.MAX_VALUE; // 가장 작은 수
        int ans = 0; // 최종 정답

        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);

            if (sum < minSum) {
                minSum = sum;
                ans = i;    // 케빈베이컨의 수가 가장 작은 사람이 정답
            }
        }

        System.out.println(ans);
    }

    private static int bfs(int start) {

        boolean[] visited = new boolean[N + 1]; // 방문 체크
        int[] distance = new int[N + 1]; // 몇 단계 떨어져 있는지

        Queue<Integer> queue = new ArrayDeque<>(); // 탐색 순서대로 줄 세우기(동적 탐색 과정)
        /* LinkedList 보다 ArrayDeque이 더 가볍고 빠름 */

        queue.add(start);
        visited[start] = true;
        distance[start] = 0; // 나와의 거리는 0

        while (!queue.isEmpty()) {
            int pick = queue.poll();

            for (int next : graph[pick]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[pick] + 1;
                    queue.add(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += distance[i];
        }
        return sum;
    }
}

