import java.io.*;
import java.util.*;

/**
 * 1074 - Z
 * 2630과 비슷한 패턴이지만 생각할 것이 좀 더 많은 문제?
 * -> 아님. 오히려 비슷하게 접근하면 N의 범위와 조건 체크로 인해 시간초과로 풀 수 없게 됨
 * r 과 c 가 0 부터 시작함에 유의
 * 각 Z의 시작점은 0,4,8,12 ...
 */

public class Main {

    static int r, c;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 2^n 지수
        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열

        calc(0, 0, 1 << N); // Z 분할 시작

    }

    private static void calc(int x, int y, int size) {

        // size 가 1이 되면 정답에 해당하는 칸에 도달했다는 말이므로 cnt 그대로 출력하고 종료
        if (size == 1) {
            System.out.println(cnt);
            return;
        }

        // (r,c)칸에 도달할 때까지 칸을 쪼갬
        int half = size / 2;

        // (r,c)칸이 1사분면에 있을 경우
        if (r < x + half && c < y + half) {
            calc(x, y, half);
        }
        // 2사분면에 있을 경우
        else if (r < x + half && c >= y + half) {
            cnt += half * half;
            calc(x, y + half, half);
        }
        // 3사분면에 있을 경우
        else if (r >= x + half && c < y + half) {
            cnt += 2 * half * half;
            calc(x + half, y, half);
        }
        // 4사분면에 있을 경우
        else if (r >= x + half && c >= y + half) {
            cnt += 3 * half * half;
            calc(x + half, y + half, half);
        }
    }
}