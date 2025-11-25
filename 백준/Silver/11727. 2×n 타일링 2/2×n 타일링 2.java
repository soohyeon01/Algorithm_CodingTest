import java.io.*;
import java.util.*;

/**
 * 11727 - 다이나믹 프로그래밍
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}

