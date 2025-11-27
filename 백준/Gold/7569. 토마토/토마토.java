import java.io.*;
import java.util.*;

/**
 * 7569 - 토마토
 * 토마토가 모두 익을 때 까지 최소 날짜, 처음부터 모든 토마토가 익은 상태 0, 토마토가 모두 익을 수 없는 상황 -1
 * 익은 토마토 1, 익지 않은 토마토 0, 빈 칸 -1
 * 익은 토마토가 익지 않은 토마토를 익게 하는데 하루가 걸림
 * 위 아래 오른쪽 왼쪽 앞 뒤 여섯방향을 익게 만듦
 * 익은 토마토가 문제마다 랜덤으로 위치하기 때문에 시작점이 한 곳이 아님 - 다중 시작점
 */
public class Main {

    static int m, n, h;
    static int[][][] box;
    static Queue<int[]> q = new LinkedList<>(); // 평면좌표 상에 시작점이 여러곳이기 때문에 반환타입 int[] 타입의 큐 생성

    // 익은 토마토의 전염(?) 방향 - 위 아래 좌 우 앞 뒤 순서
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // x
        n = Integer.parseInt(st.nextToken()); // y
        h = Integer.parseInt(st.nextToken()); // z

        // 입력 그대로 box 배열에 저장하기, 저장과 동시에 익은 토마토는 큐에 넣기
        box = new int[h][n][m];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                    if (box[k][i][j] == 1) {
                        q.add(new int[]{k, i, j});
                    }
                }
            }
        }
        // 너비 우선 탐색 시작 - 최소 일수
        bfs();

        int result = getResult();
        System.out.println(result);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] tomato = q.poll();
            int z = tomato[0];
            int x = tomato[1];
            int y = tomato[2];

            for (int dir = 0; dir < 6; dir++) {
                int nz = z + dz[dir];
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 범위를 벗어날 경우 패스
                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) continue;

                if (box[nz][nx][ny] == 0) {
                    box[nz][nx][ny] = box[z][x][y] + 1; // 나를 익게 만들어준(?) 토마토 +1
                    q.add(new int[]{nz, nx, ny});
                }
            }
        }
    }

    private static int getResult() {
        int result = 0;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 모두 탐색하였음에도 익지 않은 토마토가 남아있다면 -1
                    if (box[k][i][j] == 0) {
                        return -1;
                    }
                    // 모두 익었다면 토마토가 가진 날짜 중에 가장 큰 수를 결과로 사용
                    result = Math.max(result, box[k][i][j]);
                }
            }
        }
        // 익은 토마토의 초기값이 1로 시작하므로 -1 해줌
        return (result - 1);
    }
}