import java.util.HashMap;
import java.util.Map;

/**
 * 사진 속 인물의 그리움 점수를 모두 합산한 값이 사진의 추억 점수가 됨
 * 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return
 */
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        int[] answer = new int[photo.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            String[] capture = photo[i];
            for (String person : capture) {
                answer[i] += map.getOrDefault(person, 0);
            }
        }

        return answer;
    }
}