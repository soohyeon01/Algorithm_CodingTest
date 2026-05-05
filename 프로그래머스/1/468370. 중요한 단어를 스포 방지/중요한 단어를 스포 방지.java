import java.util.*;

/**
 * 단어는 공백으로 구분
 * 인덱스가 하나라도 spoiler_range 에 포함될 경우, 스포일러 방지 단어
 * 하나의 스포방지 구간에 여러 단어 포함 가능
 * <p>
 * 아래 조건을 모두 만족해야 중요한 단어로 판단
 * 1. 스포방지 단어
 * 2. 공개된 부분에 한 번도 등장하지 않은 단어
 * 3. 이전에 공개된 스포방지 단어와 중복되지 않는 단어
 * 4. 왼쪽부터 순차적으로 판단
 */

// 메세지에 포함된 단어와 단어의 인덱스를 저장
class Word {
    final String text;
    final int start;
    final int end;

    Word(String text, int start, int end) {
        this.text = text;
        this.start = start;
        this.end = end;
    }
}

class Solution {

    private static boolean isSpoiler(Word w, int[] range) {
        return !(w.end < range[0] || w.start > range[1]);
    }

    public int solution(String message, int[][] spoiler_ranges) {

        int cnt = 0;

        // 메세지에 포함된 단어와 인덱스를 리스트로 저장
        List<Word> words = new ArrayList<>();

        // for-loop 안에서 i를 while 로 증가 시킴 -> while-loop 로 수정
        int i = 0;
        while (i < message.length()) {

            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }

            int start = i;
            while (i < message.length() && message.charAt(i) != ' ') i++;
            words.add(new Word(message.substring(start, i), start, i - 1));
        }

        Set<String> normalWords = new HashSet<>();
        for (Word w : words) {
            boolean isSpo = false;

            for (int[] range : spoiler_ranges) {
                if (isSpoiler(w, range)) {
                    isSpo = true;
                    break;
                }
            }

            // 일반 단어 set 에 저장
            if (!isSpo) {
                normalWords.add(w.text);
            }
        }

        // 스포일러 단어지만 공개되어 카운트 된 단어
        Set<String> openSpo = new HashSet<>();

        for (int[] range : spoiler_ranges) {

            // words 리스트에 저장된 단어를 스포레인지와 비교하여 스포인 단어 학인
            for (Word w : words) {
                if (!isSpoiler(w, range)) continue;
                if (openSpo.contains(w.text)) continue;
                if (!normalWords.contains(w.text)) {
                    cnt++;
                    openSpo.add(w.text);
                }
            }
        }
        return cnt;
    }

}