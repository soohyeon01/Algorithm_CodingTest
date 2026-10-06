import java.util.Stack;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        // 원하는 카드 뭉치에서 카드를 순서대로 한장씩 사용
        // 한번 사용한 카드는 다시 사용 불가
        // 카드를 사용하지 않고 다음 카드로 넘어가기 불가
        // 기존 주어진 카드 뭉치 순서 변경 불가

        int idx1 = 0;
        int idx2 = 0;

        for (String word : goal) {

            if (idx1 < cards1.length && cards1[idx1].equals(word)) {
                idx1++;
            } else if (idx2 < cards2.length && cards2[idx2].equals(word)) {
                idx2++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}