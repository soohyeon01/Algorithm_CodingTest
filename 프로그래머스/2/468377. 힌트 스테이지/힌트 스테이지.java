/**
 * n개의 스테이지 1~n 순서대로 해결해야 함
 * 힌트권을 많이 사용할수록 비용이 줄어듦
 * i번째 힌트권은 i번째 스테이지에서만 사용가능, 하나의 스테이지에서 사용할 수 있는 힌트권 개수는 n-1개
 * 각 스테이지에서 힌트번들을 최대 1개 구매할 수 있음 - 다음 i번째 스테이지에서 사용할 수 있고 돈주고 사야됨
 * 힌트 번들에는 힌트권이 총 k장 들어있음, 같은 번호의 힌트권 여러장 포함 가능
 * <p>
 * 모든 스테이지를 해결하는데 필요한 최소 비용을 구해라
 */
class Solution {
    public int solution(int[][] cost, int[][] hint) {

        // 현재 스테이지에서 힌트 번들을 살 것인가? 앞전 스테이지에서 산 힌트권은 무조건 쓰는게 이득
        // 비트 마스킹으로 힌트 구매 여부 파악 - 마지막 스테이지에는 힌트 구매할 수 없음 (n-1)
        // 각 스테이지에 쓸 수 있는 힌트가 몇개인지 체크
        int answer = Integer.MAX_VALUE;
        int n = cost.length;

        // 2^(n-1)(= k) 번이면 힌트 구매 여부 완전 탐색 가능
        for (int mask = 0; mask < (1 << (n - 1)); mask++) {

            // 힌트 구매 여부에 따른 결과
            int total = 0;
            int[] hintCnt = new int[n];

            for (int i = 0; i < n - 1; i++) {

                //  번들 구매 여부를 확인하고, 각 스테이지에서 구매한 번들의 가격을 더함
                if ((mask & (1 << i)) != 0) {

                    total += hint[i][0];

                    // hint 배열에서 맨 앞 요소는 번들 가격을 나타냄
                    for (int j = 1; j < hint[i].length; j++) {
                        int stage = hint[i][j] -1 ;
                        hintCnt[stage]++;
                    }
                }
            }

            for (int stage = 0; stage < n; stage++) {

                // 하나의 스테이지에서 n-1 개의 힌트만 사용할 수 있음
                int useHint = Math.min(hintCnt[stage], n - 1);
                total += cost[stage][useHint];
            }

            answer = Math.min(answer, total);

        }

        return answer;
    }
}