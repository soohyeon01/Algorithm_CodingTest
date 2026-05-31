import java.util.Arrays;

/**
 * 출근 희망 시각 + 10분까지 어플로 출근해야함
 * 단, 토요일 일요일의 출근 시각은 이벤트에 영향을 끼치지 않음
 * 모든 시각은 10시 13분 -> 1013, 9시 58분 -> 958 정수로 표현됨
 * 상품을 받을 직원은 몇명인가?
 * 출근 희망 시각: 1차원 정수 배열 schedules, 실제 출근한 시각: 2차원 정수 배열 timelogs, 이벤트 시작 요일: 정수 startday
 */

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {

        // 희망 시각 + 10을 했을 때, 뒤에서 두자릿수가 60이상이면 시간에 +1
        // 출근 맥시멈 시간을 저장
        int[] timeMax = new int[schedules.length];
        for (int i = 0; i < timeMax.length; i++) {
            timeMax[i] = schedules[i] + 10;
            if (timeMax[i] % 100 > 59) {
                timeMax[i] = timeMax[i] + 40;
            }
        }

        // 요일이 6 7 이 되면 그 날의 시각은 패스, 요일을 7까지 세고 나면 다시 1로 돌아감
        // 플래그 배열을 생성하여 성공한 사람과 실패한 사람 관리
        // 마지막으로 루프를 돌려서 플래그가 true 인 사람 카운트
        boolean[] check = new boolean[schedules.length];
        Arrays.fill(check, true);

        for (int i = 0; i < schedules.length; i++) {
            for (int j = 0; j < 7; j++) {

                int day = (j + startday - 1) % 7 + 1;

                if (day == 6 || day == 7) {
                    continue;
                }

                if (timelogs[i][j] <= timeMax[i]) {
                    continue;
                } else {
                    check[i] = false;
                    break;
                }
            }
        }

        int answer = 0;
        for (boolean b : check) {
            if (b) {
                answer++;
            }
        }
        return answer;
    }
}