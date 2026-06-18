import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 자기 바로 앞 선수를 추월하면, 추월한 선수의 이름을 부름
 *
 * 선수는 최대 50000, 부른 이름은 최대 100000
 */

class Solution {
    public String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int rank = map.get(callings[i]);
            String curr = players[rank];
            String front = players[rank - 1];

            // arr - swap
            players[rank] = players[rank - 1];
            players[rank - 1] = curr;

            // map - swap
            map.put(curr, rank - 1);
            map.replace(front, rank);
        }

        return players;
    }
}