/**
 *
 */
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        // 서버를 k시간 운영한 후, 반납되어야하는 타이밍 저장할 변수 필요
        int[] expired = new int[players.length + k + 1];

        // 현재 증설된 서버 수
        int curServer = 0;
        for (int i = 0; i < players.length; i++) {

            int user = players[i];

            // 만료된 서버는 반납
            curServer -= expired[i];

            int need = user / m;

            // 현재 운영중인 서버 수 안에서 시간당 사용자가 감당가능한 수준인지?
            if (need > curServer) {
                int increase = need - curServer;

                answer += increase;
                curServer += increase;

                expired[i + k] += increase;
            }
        }

        return answer;
    }
}