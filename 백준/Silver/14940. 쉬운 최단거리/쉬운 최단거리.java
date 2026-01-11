import java.io.*;
import java.util.*;

/**
 * 14940 - 쉬운 최단거리 (너비우선탐색)
 * 모든 점에서 목표 지점까지의 거리 구하기, 가로 세로로만 움직일 수 있음(상하좌우 이동)
 * 입력 - 0: 갈 수 없는 땅, 1: 갈 수 있는 땅, 2: 목표 지점(시작점)
 * 출력 - 0: 원래 갈 수 없는 땅, -1: 원래 갈 수 있지만 도달할 수 없는 땅, A: 각 지점에서 목표 지점까지의 거리
 */

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] dist;
    static Queue<int[]> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        map = new int[n][m]; // 초기값 입력
        dist = new int[n][m]; // 초기값 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }
        bfs();
        getResult();
        System.out.println(sb);
    }

    private static void getResult() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && dist[i][j] == -1) {
                    sb.append("-1 ");
                } else if (map[i][j] ==0) {
                    sb.append("0 ");
                } else if (map[i][j] == 2) {
                    sb.append("0 ");
                } else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (map[nx][ny] == 1 && dist[nx][ny] ==-1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

    }
}