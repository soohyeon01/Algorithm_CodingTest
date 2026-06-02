import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 끝말잇기
 * 가장 먼저 탈락하는 사람의 번호와, 그 사람이 자신의 몇번째 차례에 탈락하는지 return
 * 탈락자가 생기지 않는다면 [0,0] return
 * <p>
 * 이전에 등장한 단어는 사용할 수 없고, 한글자 단어는 인정되지 않음
 */
class Solution {
    public int[] solution(int n, String[] words) {

        // 이미 말한 문자를 담을 HashSet
        HashSet<String> hashSet = new HashSet<>();

        // 정답을 담을 배열
        int[] answer = {};

        if (words[0].length() != 1) {
            hashSet.add(words[0]);
        }

        // 단어 전체의 개수를 iter
        for (int i = 1; i < words.length; i++) {

            String preWord = words[i - 1];
            char last = preWord.charAt(preWord.length() - 1);
            String curWord = words[i];
            char first = curWord.charAt(0);

            // 탈락조건: 한글자 단어, 끝말잇기를 하지 않은 경우, 이미 나왔던 단어를 사용,
            if (curWord.length() == 1 || last != first || hashSet.contains(words[i])) {
                // 틀린 사람이 나오면 전체 인원수로 나누어 몇번째 사람인지 구함
                answer = new int[]{(i % n) + 1, (i / n) + 1};
                return answer;
            }

            hashSet.add(curWord);
        }

        answer = new int[]{0, 0};
        return answer;
    }
}