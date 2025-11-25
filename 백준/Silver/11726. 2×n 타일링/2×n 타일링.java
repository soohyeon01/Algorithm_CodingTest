import java.io.*;
import java.util.*;

/**
 * 11726 - 다이나믹 프로그래밍
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // dp 배열 생성
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }   // 오버플로우 방지를 위해 배열에 저장할 때부터 나머지로 저장함

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}