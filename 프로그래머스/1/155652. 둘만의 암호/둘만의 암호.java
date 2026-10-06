import java.util.Arrays;

class Solution {
    public String solution(String s, String skip, int index) {
/**
 *         문자열 s의 각 알파벳을 index 만큼 뒤의 알파벳으로 바꿈
 *         z 이상의 알파벳일 경우, a로 돌아감
 *         skip 에 있는 알파벳은 제외하고 건너뜀
 *
 *         알파벳을 숫자로 치환하여, 해당 숫자를 만나면 skip
 *         문자열이 완성되면 숫자를 문자열로 치환?
 */

        String answer = "";

        // 건너뛰는 숫자를 boolean 배열로
        boolean[] comp = new boolean[26];
        for (char c : skip.toCharArray()) {
            comp[c - 'a'] = true;
        }

        for (char c : s.toCharArray()) {

            int count = 0;
            int current = c - 'a';

            while (count < index) {

                // current를 다음 알파벳으로 이동
                current = (current + 1) % 26;

                // skip이 아니라면 count 증가
                if (!comp[current]) {
                    count++;
                }
            }

            char alphabet = (char) (current + 'a');
            answer += alphabet;
        }
        return answer;
    }
}
