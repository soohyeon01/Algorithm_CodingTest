/**
 * 항상 길이가 긴 쪽을 반으로 접음
 * 접은 후 소수점 이하는 버림
 * 90도 돌려서 넣을 수 있으면 멈춤
 * 지갑에 넣기 위해 지폐를 최소한 몇번 접어야 하는지
 */
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (min(wallet) < min(bill) || max(wallet) < max(bill)) {

            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else bill[1] /= 2;

            answer++;
        }
        
        return answer;
    }

    private int max(int[] arr) {
        return Math.max(arr[0], arr[1]);
    }

    private int min(int[] arr) {
        return Math.min(arr[0], arr[1]);
    }
}