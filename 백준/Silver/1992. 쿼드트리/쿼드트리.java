import java.io.*;
import java.util.*;

/**
 * 1992 - 쿼드트리
 * 2630과 비슷한 패턴으로 풀 수 있는 문제
 */

public class Main {

    static int[][] image;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 영상 크기
        image = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                image[i][j] = line.charAt(j) -'0'; // 숫자 변환 주의하기
            }
        }

        calc(0, 0, N); // 영상 분할 시작

        System.out.println(sb);
    }

    private static void calc(int x, int y, int size) {
        int point = image[x][y];
        for (int i = x; i < x + size ; i++) {
            for (int j = y; j < y + size; j++) {
                if (image[i][j] != point) {
                    int half = size / 2;
                    // 로직을 타는 순서 중요 - 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래
                    sb.append("(");
                    calc(x, y, half);
                    calc(x, y + half, half);
                    calc(x + half, y, half);
                    calc(x + half, y + half, half);
                    sb.append(")");
                    return;
                }
            }
        }

        // 재귀되지 않고 로직을 타고 내려오면 숫자출력
        if (point == 0) {
            sb.append(0);
        } else sb.append(1);
    }
}