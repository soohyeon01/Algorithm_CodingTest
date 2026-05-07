import java.util.HashMap;
import java.util.Map;

/**
 * 두 사람이 선물을 주고 받은 기록이 있다면, 선물을 더 많이 준 사람이 다음 달에 선물 하나 받음
 * 두 사람이 선물을 받은 기록이 하나도 없거나 주고 받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물 하나 받음
 * 선물 지수도 같다면 선물을 주고 받을 필요 없음
 */

class Solution {
    public int solution(String[] friends, String[] gifts) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        int num = friends.length;
        int[][] change = new int[num][num]; // 문제 예시처럼 [giver][receiver] 배열을 실제로 구현
        int[] giftIndex = new int[num]; // 각 인물의 선물인덱스 저장

        for (String gift : gifts) {
            String[] parts = gift.split(" ");

            int giverIdx = map.get(parts[0]);
            int receiverIdx = map.get(parts[1]);

            // 1. 서로 교환한 선물의 수
            change[giverIdx][receiverIdx]++;
            
            // 2. 선물 지수
            giftIndex[giverIdx]++;
            giftIndex[receiverIdx]--;
        }

        // 3. 다음 달 받을 선물의 수
        int[] nextGift = new int[num];

        for (int i = 0; i < num-1; i++) {
            for (int j = i + 1; j < num; j++) {

                int give = change[i][j]; // i -> j
                int receiver = change[j][i]; // j -> i

                if (give > receiver) {
                    nextGift[i]++;
                } else if (give < receiver) {
                    nextGift[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) {
                        nextGift[i]++;
                    } else if (giftIndex[i] < giftIndex[j]) {
                        nextGift[j]++;
                    } else continue;
                }
            }
        }

        // 가장 많은 선물을 받는 친구가 받을 선물의 수 return
        int answer = 0;
        for (int n : nextGift) {
            answer = Math.max(n, answer);
        }

        return answer;
    }
}