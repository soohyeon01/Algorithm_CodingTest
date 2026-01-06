import java.io.*;
import java.util.*;

/**
 * 2630 - 색종이 만들기 (재귀, 분할 정복)
 * 모두 같은 색으로 칠해져있지 않으면 종이의 가로 세로 중간 부분을 자름
 * 입력: 하얀색 칸은 0, 파란색 칸은 1
 * 출력: 하얀색 종이의 개수와 파란색 종이의 개수
 */

public class Main {

    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 색종이 한 변의 길이
        paper = new int[N][N]; // 색종이
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc(0, 0, N); // 색종이 나누기 시작

        sb.append(white).append("\n").append(blue);

        System.out.println(sb);

    }

    private static void calc(int x, int y, int size) {
        // 리팩토링 하면서 메서드로 분리
        int point = paper[x][y];
        for (int i = x; i < x + size ; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != point) {
                    int half = size / 2;
                    // 한면은 항상 4등분 되므로 4분할 모두 검사해아 함.
                    calc(x, y, half);
                    calc(x, y + half, half);
                    calc(x + half, y, half);
                    calc(x + half, y + half, half);
                    return;
                }
            }
        }

        // 전부 같은 색으로 위의 로직을 타고 끝까지 내려오면 종이 수++
        if (point == 0) {
            white++;
        } else blue++;
    }
}