import java.io.*;
import java.util.*;

/**
 * 10026 - 적록색약
 * 인접한 R G B 를 각 구역으로 나눌 때, 적록색약이 봤을 때와 아닌 사람이 봤을 때의 구역의 개수 구하기
 */

public class Main {

    static int N;
    static char[][] picture;
    static boolean[][] visited;
    static int result;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // N x N 그림

        picture = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                picture[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        sb.append(result).append(" "); // 적록색약이 아닌 사람이 봤을 경우


        result = 0; // 결과를 0으로 초기화
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        } // 방문 기록 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j] == 'G') {
                    picture[i][j] = 'R';
                    // G를 R로 변경
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        sb.append(result); // 적록색약인 사람이 봤을 경우

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>(); // 새로운 구역을 만나면 큐 초기화
        q.add(new int[]{x, y});
        visited[x][y] = true;
        result++; // 구역의 수 증가

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (picture[nx][ny] == picture[cur[0]][cur[1]] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}

