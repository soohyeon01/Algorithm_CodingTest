import java.io.*;
import java.util.*;

/**
 * 16928 - 뱀과 사다리 게임
 * 주사위가 원하는 숫자대로 나온다고 가정했을 때, 100번 칸에 도달하려면 주사위를 최소 몇 번 굴려야 하는가?
 * 주사위: 1~6 , 보드판: 10 * 10 (총 100칸)
 * !주사위를 굴렸을 때, 도착칸이 100번을 넘어간다면 이동 불가
 * !도착칸이 사다리면 사다리를 따라 위로 올라가고(전진), 뱀이라면 뱀을 따라 아래로 내려감(후진)
 * <p>
 * 1 <= 사다리의 수, 뱀의 수 <= 15
 * ! 1번 칸과 100번 칸은 사다리나 뱀이 아니고, 모든 칸은 동시에 두가지를 가질 수 없음
 */

public class Main {

    // 보드판, 방문체크, 거리계산
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];
    static int[] dist = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사다리의 수 N, 뱀의 수 M
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N 만큼 x, y ( x < y)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x에 도착하면 y로 이동
            board[x] = y;
        }

        // M 만큼 u, v ( u > v)
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // u에 도착하면 v로 이동
            board[u] = v;
        }

        // bfs 시작
        bfs(1);
    }

    private static void bfs(int start) {

        // 큐 생성
        Queue<Integer> queue = new ArrayDeque<>();

        // 시작점 큐에 넣기, 방문체크, 거리설정
        queue.add(start);
        visited[start] = true;
        dist[start] = 0;

        // bfs 시작
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int dice = 1; dice <= 6; dice++) {

                int next = current + dice;

                // 100을 초과하는 칸으로는 이동 못함
                if (next > 100) continue;

                // 다음칸이 사다리나 뱀으로 연결되어 있다면, 연결된 칸을 방문 처리하고 큐에 넣어줌
                if (board[next] != 0) {
                    next = board[next];
                }

                // 처음 방문하는 칸이면 방문 처리 후, 큐에 넣고 다음 단계로
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
        }

        // 최단거리 출력
        System.out.println(dist[100]);
    }
}

