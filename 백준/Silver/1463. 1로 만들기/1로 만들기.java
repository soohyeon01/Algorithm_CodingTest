import java.io.*;
import java.util.*;

/**
 * 다이나믹 프로그래밍, 그리디 알고리즘으로 해결 불가
 * DP: 모든 경우의 최소값을 미리 계산해 나가는 방식
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];  // n을 1로 만드는 최소 연산 횟수

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;  // i를 1로 만드는 최소 연산 횟수는 i-1을 1로 만드는 최소 연산 +1을 하면 됨

            // i가 2or3 으로 나누어 떨어지는 수일 때, 위에서 구한 dp[i]와 dp[i/2 or i/3] + 1 과 비교하여 작은 수를 dp[i]에 저장
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); 
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[n]);
    }
}