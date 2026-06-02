/**
 * 운반 최단 시간 구하기
 * 건설이 가능해지는 최초의 시간 탐색 -> 이분탐색 알고리즘 사용
 */

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {

        int city = g.length;
        long answer = 0;
        long left = 0;
        long right = 4L * 100000000000000L;

        // 이분탐색 시작
        while (left <= right) {

            long mid = (left + right) / 2;

            // 현재 지정된 시간 안에 운반 가능하다면
            if (isPossible(mid, city, a, b, g, s, w, t)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;

    }

    private boolean isPossible(long time, long city, int a, int b, int[] g, int[] s, int[] w, int[] t) {

        long gold = 0;
        long silver = 0;
        long total = 0;

        for (int i = 0; i < city; i++) {

            // i번째 도시에서 왕복 가능한 횟수
            long cnt = time / (2L * t[i]);
            if (time % (2L * t[i]) >= t[i]) {
                cnt++;
            }

            // i번째 도시에서 운반 가능한 무게
            long cap = cnt * w[i];

            // 각 도시에서 운반 가능한 금의 무게 합
            gold += Math.min(g[i], cap);

            // 각 도시의 운반 가능한 은의 무게 합
            silver += Math.min(s[i], cap);

            // 실제로 가능한 총량
            total += Math.min(g[i] + s[i], cap);

        }

        return gold >= a && silver >= b && total >= a + b;
    }
}