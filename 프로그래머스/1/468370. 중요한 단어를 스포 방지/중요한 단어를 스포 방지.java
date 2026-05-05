// 스포 방지 기능
// 왼쪽 -> 오른쪽 순서로 스포방지 구간을 하나씩 클릭해, 중요한 단어가 몇 개인지 확인

import java.util.*;

/**
 * 단어는 공백으로 구분, 알파벳 소문자와 숫자로만 구성된 연속된 문자열
 * 댠어를 구성하는 문자들의 인덱스 중 하나라도 스포 방지 구간에 포함 될 경우 해당 단어는 스포일러 방지 단어로 간주
 * 하나의 스포방지 구간에 여러 단어 포함 가능
 * <p>
 * 스포 방지 단어가 공개되었을 때, 아래 조건을 모두 만족해야 중요한 단어로 판단
 * 1. 스포방지 단어
 * 2. 공개된 부분에 한 번도 등장하지 않은 단어
 * 3. 이전에 공개된 스포방지 단어와 중복되지 않는 단어
 * 4. 여러 단어가 동시에 공개 된 경우, 왼쪽부터 순서대로 하나씩 중요한 단어인지 판단
 */

// 메세지에 포함된 단어와 단어의 인덱스를 저장
class Word {
    String text;
    int start;
    int end;
}

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {

        int cnt = 0;

        // 메세지에 포함된 단어와 인덱스를 리스트로 저장
        List<Word> words = new ArrayList<>();
        for (int i = 0; i < message.length(); i++) {

            // 공백이면 뛰어넘고, 문자면 인덱스를 저장
            if (message.charAt(i) == ' ') {
                continue;
            }

            int start = i;
            // 문자열의 끝이 아니라면, 다시 공백을 만날 때 까지 i증가
            while (i < message.length() && message.charAt(i) != ' ') {
                i++;
            }
            int end = i - 1;

            Word word = new Word();
            word.text = message.substring(start, end + 1);
            word.start = start;
            word.end = end;

            words.add(word);
        }

        // spoiler_range 와 저장된 단어를 비교
        // 스포 방지 구간이 아닌 영역에서 등장한 단어 저장
        Set<String> normal_words = new HashSet<>();
        for (Word w : words) {
            boolean isSpo = false;

            for (int[] range : spoiler_ranges) {
                if (!(w.end < range[0] || w.start > range[1])) {
                    isSpo = true;
                    break;
                }
            }

            // 스위치가 바뀌지 않았다면 일반 단어 set에 저장
            if (!isSpo) {
                normal_words.add(w.text);
            }
        }

        // 스포일러 단어지만 공개되어 카운트 된 단어
        Set<String> open_spo = new HashSet<>();


        for (int[] range : spoiler_ranges) {

            int start = range[0];
            int end = range[1];

            List<Word> check = new ArrayList<>();

            // words 리스트에 저장된 단어를 스포레인지와 비교하여 스포인 단어 학인
            // 단어의 일부분만 스포처리 되어있을 수도 있고, 여러 단어가 한번에 스포처리 될 수 있음
            for (Word w : words) {

                if (!(w.end < start || w.start > end)) {
                    check.add(w);
                }
            }

            for (Word w : check) {

                // 이미 카운트 된 단어 제외
                if (open_spo.contains(w.text)) continue;

                // 스포방지 영역에서 등장하지 않았고, 이미 카운트 된 단어가 아니면 중요한 단어로 저장
                if (!normal_words.contains(w.text) && !open_spo.contains(w.text)) {
                    cnt++;
                    open_spo.add(w.text);
                }
            }
        }
        return cnt;
    }
}