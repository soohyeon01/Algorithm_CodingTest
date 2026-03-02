import java.io.*;
import java.util.*;

/**
 * 14500 - 테트로미노 (DFS)
 * 조각하나가 면 위에 올라갔을 때, 네칸의 합이 가장 큰 경우 찾기
 */

public class Main {

    static int N;
    static int M;
    static int[][] paper;
    static boolean[][] visited;
    static int max = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 종이의 세로 가로 크기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 종이 배열
        paper = new int[N][M];
        visited = new boolean[N][M];
        
        // 종이에 적혀 있는 숫자
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든칸에서 DFS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]); // 현재 블록을 depth = 1로 잡고, 4가 될때까지 dfs
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y, int depth, int sum) {

        // 블록이 4개 모이면 최대값 갱신
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny <0|| ny >= M) continue;
            if(visited[nx][ny]) continue;

            // ㅗ 모양 처리 (ㄱ, ㅡ , ㅁ , Z 모양과 달리 가운데 블록이 기준점이 되어야 ㅗ 를 만들 수 있음)
            if (depth == 2) {
                visited[nx][ny] = true;
                dfs(x, y, depth + 1, sum + paper[nx][ny]);
                visited[nx][ny] = false;
            }

            // 나머지 도형 처리
            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + paper[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}

