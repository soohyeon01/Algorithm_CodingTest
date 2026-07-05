import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    아무렇게나 만든 휴대폰 자판
    키의 개수가 1~100개, 특정키 입력 무작위 배열
    같은 문자가 자판 전체에 여러개 할당된 경우, 키 하나에 같은 문자가 여러번 할당된 경우 모두 가능
    아예 할당되지 않은 경우도 있음
    해당 자판을 사용하여, 키를 최소 몇 번 눌러야 그 문자열을 작성할 수 있는지

    키에는 알파벳 대문자만 할당되어있음
 */
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> result = new ArrayList<>();   // 해당 문자열을 입력하려면 몇 번 눌러야 하는지 리스트로 저장

        int[] min = new int[26];
        Arrays.fill(min, 200);

        for (String key : keymap) {
            for (int j = 0; j < key.length(); j++) {
                char c = key.charAt(j);
                // 'A' - 'A' 를 배열의 번호로 하고, 해당 번호에 가장 적게 누를 수 있는 수를 저장
                int idx = c - 'A'; // 배열에 저장할 번호
                min[idx] = Math.min(min[idx], j + 1);
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                int idx = targets[i].charAt(j) - 'A';
                if (min[idx] == 200) {
                    sum = -1;
                    break;
                } else {
                    sum += min[idx];
                }
            }
            result.add(sum);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}