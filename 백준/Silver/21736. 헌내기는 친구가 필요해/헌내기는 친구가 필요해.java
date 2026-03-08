import java.io.*;
import java.util.*;

/**
 * 21736 - 헌내기는 친구가 필요해
 */

public class Main {

    static int N, M;
    static int cnt = 0;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N x M 크기의 캠퍼스
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        // I 시작점, O 이동할 수 있는 공간, X 이동 불가능한 벽, P 만날 수 있는 사람 -> 숫자형태로 저장? -> 굳이...
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                // 범위 체크
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                // 벽이 있거나 이미 방문 했을 경우
                if(map[nx][ny] == 'X' || visited[nx][ny]) continue;
                
                // 길이 있거나, 친구가 있을 경우
/*
                if (map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                } else if (map[nx][ny] == 2) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    cnt++;
                }
*/
                // 코드 수정
                if(map[nx][ny] == 'P') cnt++;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        if (cnt == 0) {
            System.out.println("TT");
        } else System.out.println(cnt);

    }

}

