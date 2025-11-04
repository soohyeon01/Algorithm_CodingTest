import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    /**
     * 피보나치 함수 / 다이나믹 프로그래밍 / 재귀로 직접 구현시 시간초과
     * 0 <= n <= 40
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스의 수
        int t = Integer.parseInt(br.readLine());
        int[][] fibo = new int[41][2];

        // n = 0, n = 1 일때 값 미리 세팅
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        // 피보나치 함수 규칙
        for (int i = 2; i < 41; i++) {
            fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
            fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(fibo[n][0]).append(" ").append(fibo[n][1]).append("\n");
        }

        System.out.println(sb);
    }
}

