import java.util.Arrays;

/**
 * 이분 탐색?
 */
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        int n = diffs.length;
        int left = 1;
        int right =  Arrays.stream(diffs).max().getAsInt();
        int answer = 0;

        while (left <= right) {

            long total = 0;
            int mid = (left + right) / 2;

            total += times[0];
            for (int i = 1; i < n; i++) {
                if (diffs[i] <= mid) {
                    total += times[i];
                } else {
                    // 틀리면 전 퍼즐을 다시 풀고 와야 기회가 생김 + 문제를 풀어서 통과하는 시간
                    long clear = (long) (times[i] + times[i - 1]) * (diffs[i] - mid) + times[i];
                    total += clear;
                }
            }

            // limit 안에 문제를 풀면 나의 레벨을 내리고, 못 풀면 레벨을 올림
            if (total <= limit) {
                right = mid - 1;
                answer = mid;

            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}