import java.io.*;
import java.util.*;

/**
 * 2579 - 계단 오르기 - 다이나믹 프로그래밍
 * 계단은 한번에 하나 or 두개
 * 연속된 세개의 계단 밟기 안됨 - 시작점을 제외하고 2번 연속 한계단 오르기 불가능
 * 마지막 도착 계단 반드시 밟아야 됨
 * 총 점수의 최댓값을 구해야 함
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stair = Integer.parseInt(br.readLine()); // 계단의 수
        int[] score = new int[stair + 1];
        int[] dp = new int[stair + 1];

        score[0] = 0;
        for (int i = 1; i < score.length; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 계단의 수가 2 이하인 경우 따로 처리
        if (stair == 1) {
            System.out.println(score[1]);
            return;
        }
        if (stair == 2) {
            System.out.println(score[1] + score[2]);
            return;
        }

        // 계단의 수가 3 이상인 경우 
        dp[0] = score[0];
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        
        // 마지막 도착 계단을 반드시 밟아야 하며, 연속 3 계단 금지 + 뛰어넘을 수 있는 계단의 수 -> 아래의 두 조합으로 마지막 계단에 도달 가능
        for (int i = 3; i < score.length; i++) {
            dp[i] = Math.max((dp[i - 2] + score[i]), (dp[i - 3] + score[i - 1] + score[i]));
        }
        System.out.println(dp[stair]);
    }
}

