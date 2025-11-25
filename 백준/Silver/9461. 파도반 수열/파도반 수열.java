import java.io.*;
import java.util.*;

/**
 * 9461 - 다이나믹 프로그래밍
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] p = new long[101];
        p[1] = p[2] = p[3] = 1;
        p[4] = p[5] = 2;
        p[6] = 3;
        p[7] = 4;
        p[8] = 5;
        for (int i = 9; i < p.length; i++) {
            p[i] = p[i - 1] + p[i - 5];
        }

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 삼각형의 개수
            sb.append(p[N]).append("\n");
        }
        
        System.out.println(sb);
    }
}

