import java.io.*;
import java.util.*;

/**
 * 2178
 * 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
 * 1,1 에서 출발하여 N,M 으로 이동할 때 지나야하는 최소 칸 수는?
 * => 그래프탐색
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인접칸으로만 이동 가능
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        // BFS
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        System.out.println(arr[N - 1][M - 1]);
    }
}


