import java.util.Arrays;

class Solution {

    // int[][] signal = new int[n][3];
    // 노란불인지 아닌지 -> 시간 t를 각 신호등의 신호 주기로 나눴을 때의 나머지 p가 G < p <= G + Y 이면 노란불

    public int solution(int[][] signals) {

        int t = 1; // 시간

        // 각 신호등의 신호 주기
        int[] sigSum = new int[signals.length];
        for (int i = 0; i < signals.length; i++) {
            sigSum[i] = Arrays.stream(signals[i]).sum();
        }

        // 적당한 범위를 정하여 모든 신호등이 노란불이 되는 경우가 존재하지 않는 경우 -1 return
        while (t <= 2000000) {

            boolean allYellow = true;

            for (int i = 0; i < signals.length; i++) {
                int p = t % sigSum[i];

                int g = signals[i][0]; // 초록불
                int y = signals[i][0] + signals[i][1]; // 노란불

                // 노란불 범위에 들어오지 않는 신호등이 하나라도 있으면 false
                if (!(g < p && p <= y)) {
                    allYellow = false;
                    break;
                }
            }

            // 모든 신호등이 노란불이 되는 시각을 return
            if (allYellow) return t;

            t++;
        }

        // t를 이백만까지 검사해도 모든 신호등이 노란불이 되는 경우가 없다면 -1을 return
        return -1;
    }
}   