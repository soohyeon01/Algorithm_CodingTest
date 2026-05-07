import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * n개의 노드를 가진 하나의 트리
 * 파이프의 종류 : 1, 2, 3
 * 하나의 감염된 배양체가 주어지고, 감염된 배양체는 인접한 배양체를 감염시킴
 * 종류가 같은 파이프를 모두 열었다가 모두 닫을 수 있음
 * 단, 두 개 이상의 파이프를 동시에 열 수는 없음
 * k번의 행동을 반복해 최대한 많은 배양체를 감염시키는 방법
 * edge[i] = [x, y, type]
 */

class Solution {

    // 각 노드는 다음 노드와 파이프 타입을 가지고 있음
    static class Node {
        int next;
        int type;

        public Node(int next, int type) {
            this.next = next;
            this.type = type;
        }
    }

    // 여러 메서드에서 쓰는 변수는 static으로 선언
    static int ans = 0;
    static int k;

    // Node 타입 그래프 생성
    static ArrayList<Node>[] graph;

    public int solution(int n, int infection, int[][] edges, int k) {

        this.k = k;

        // 1. 양방향 그래프 생성
        graph = new ArrayList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];

            graph[x].add(new Node(y, type));
            graph[y].add(new Node(x, type));
        }

        // 2. 감염 확인
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        // 3. dfs 시작 (depth: 1~k)
        // k가 문제에서 주어지기 때문에 dfs로 시작
        dfs(0, infected);

        return ans;
    }

    private void dfs(int depth, boolean[] infected) {

        // 현재 감염된 노드의 수
        int cnt = 0;
        for (boolean b : infected) {
            if (b) cnt++;
        }

        // dfs 내부에서 도출된 cnt 값과 이전 ans 값을 비교해 최댓값을 ans로 저장
        ans = Math.max(cnt, ans);

        // 최대 depth에 도달하면 탐색 종료
        if (depth == k) {
            return;
        }

        // type 별로 탐색 시작
        for (int type = 1; type <= 3; type++) {

            // 1, 2, 3 이 독립적인 경우이기 때문에, 백트래킹을 위해 클론 배열 생성
            boolean[] nextInfected = infected.clone();

            // bfs
            bfs(nextInfected, type);

            dfs(depth + 1, nextInfected);

        }
    }

    private static void bfs(boolean[] nextInfected, int type) {
        Queue<Integer> queue = new LinkedList<>();

        // 모든 감염된 노드가 시작점이 됨
        for (int i = 1; i < nextInfected.length; i++) {
            if (nextInfected[i]) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (Node node : graph[cur]) {

                int next = node.next;
                int pipeType = node.type;

                // type이 1~3으로 저정되어 있으므로, pipe type이 같지 않으면 전염 불가
                if (pipeType != type) {
                    continue;
                }

                // 다음 노드도 감염된 노드일 경우 건너뜀
                if (nextInfected[next]) {
                    continue;
                }

                // 현재 노드와 다음 노드의 파이프타입이 같고 다음 노드가 감염되지 않은 상태라면 감염으로 상태를 바꿈
                nextInfected[next] = true;

                queue.add(next);
            }
        }

    }
}



