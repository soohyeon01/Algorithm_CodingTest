class Solution {
    public int solution(int n, int m, int[] section) {

        int answer = 0;
        int complete = 0;

        for (int s : section) {
            if(s <= complete) continue;

            answer++;

            complete = s + m - 1;
        }

        return answer;
    }
}