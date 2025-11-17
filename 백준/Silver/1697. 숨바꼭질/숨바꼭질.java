import java.io.*;
import java.util.*;

/**
 * 너비 우선 탐색
 * 동생을 찾는 가장 빠른 시간 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수빈의 위치
        int k = Integer.parseInt(st.nextToken()); // 동생의 위치

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001]; // 중복 검사
        int[] dist = new int[100001]; // 최단 시간 저장

        q.add(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) {
                System.out.println(dist[cur]);
                break;

            }

            int[] next = {cur - 1, cur + 1, cur * 2};

            for (int i : next) {
                if (i >= 0 && i <= 100000 && !visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[cur] + 1;
                    q.add(i);
                }
            }
        }

    }
}