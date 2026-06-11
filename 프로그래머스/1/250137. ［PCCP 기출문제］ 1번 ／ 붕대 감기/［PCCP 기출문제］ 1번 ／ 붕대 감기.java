/**
 * 기술 완료 하면 추가 체력 획득, 최대 체력을 넘을 수 없음
 * 기술을 쓰는 도중 공격 당하면 기술 취소, 공격 당하는 순간에는 회복 불가능, 연속 성공시간 0으로 초기화
 * 공격을 당하면 피해량만큼 체력이 줄어들고, 체력이 0이 되면 사망
 * <p>
 * bandage: 기술 시간(t), 1초당 회복력(x), 추가 회복량(y)
 * health: 최대 체력
 * attacks: 공격 시간, 피해량
 * return -> 모든 공격이 끝난 직후 남은 체력, 죽었으면 -1
 */
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // 최대 체력을 저장해두고 시작
        int max = health;

        // 첫번째 공격 전에는 체력을 충전할 수 없음
        // 첫번째 공격이 완료된 상태로 loop를 시작함
        health -= attacks[0][1];
        if (health <= 0) {
            return -1;
        }

        for (int i = 1; i < attacks.length; i++) {

            // 공격 당하기 전까지 체력 충전 가능
            // 공격 텀이 기술시간 이상인 경우 추가 체력 획득
            int t = attacks[i][0] - attacks[i - 1][0] - 1;
            if (t >= bandage[0]) {
                health += (t/ bandage[0]) * bandage[2];
            }
            health += bandage[1] * t;

            // 최대를 넘으면 다시 최대 체력으로 복귀
            if (health >= max) {
                health = max;
            }

            // i시간에 몬스터에게 한번 공격 받음
            health -= attacks[i][1];
            if (health <= 0) {
                return -1;
            }
        }

        return health;
    }
}