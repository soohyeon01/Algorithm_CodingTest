/**
 * 항상 길이가 긴 쪽을 반으로 접음
 * 접은 후 소수점 이하는 버림
 * 90도 돌려서 넣을 수 있으면 멈춤
 * 지갑에 넣기 위해 지폐를 최소한 몇번 접어야 하는지
 */
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int walletS = Math.min(wallet[0], wallet[1]);
        int walletL = Math.max(wallet[0], wallet[1]);
        int billS = Math.min(bill[0], bill[1]);
        int billL = Math.max(bill[0], bill[1]);

        while (walletS < billS || walletL < billL) {
            billL /= 2;

            // 지폐의 긴 쪽을 접었을 때 원래 짧은 쪽 보다 짧아지면 둘을 바꿈
            if (billL < billS) {
                int temp = billS;
                billS = billL;
                billL = temp;
            }

            answer++;

        }
        return answer;
    }
}