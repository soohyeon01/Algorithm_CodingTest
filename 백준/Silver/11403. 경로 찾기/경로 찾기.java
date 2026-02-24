import java.io.*;
import java.util.*;

/**
 * 11403 - 경로찾기
 * 단방향 그래프에서 i -> j 로 이동 가능하면 1을 출력
 * 자기 자신도 재방문 할 수 있어야 1로 처리 가능
 */

public class Main {

    static int N;
    static ArrayList<Integer>[] graph; // 간선 그래프
    static int[][] result;// 결과를 저장하는 2차원 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 정점의 개수 입력
        N = Integer.parseInt(br.readLine());

        // result 배열 초기화
        result = new int[N][N];

        // 그래프 초기화
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 인접 행렬 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    graph[i].add(j); // 단방향 그래프
                }
            }
        }

        // 모든 정점에서 bfs 실행
        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

/*        // 플로이드 - 워셜
        int[][] graphF = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graphF[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graphF[i][k] == 1 && graphF[k][j] == 1) {
                        graphF[i][j] = 1;
                    }
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graphF[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
*/

        System.out.println(sb);
    }

    private static void bfs(int start) {

        // 시작점이 달라질 때마다 visited 배열 새로 만들기
        boolean[] visited = new boolean[N];

        // bfs에 필요한 큐 생성
        Queue<Integer> queue = new ArrayDeque<>();

        // 시작점에서 다른 정점들을 거쳐 다시 시작점으로 돌아올 수 있어야 방문체크 가능 (자기 자신이라고 무조건 돌아올 수 있는거 아님)
        queue.add(start);

        // while-loop 시작
        while (!queue.isEmpty()) {
            int pick = queue.poll();

            // graph - iter
            for (int next : graph[pick]) {
                if (!visited[next]) {
                    visited[next] = true;
                    // 방문 가능한 정점은 1
                    result[start][next] = 1;
                    queue.add(next);
                }
            }
        }
    }
}

