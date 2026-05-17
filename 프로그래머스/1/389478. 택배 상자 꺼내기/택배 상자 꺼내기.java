// 꺼내려는 상자를 포함하여 총 몇개의 택배 상자를 꺼내야 하는지
class Solution {
    public int solution(int n, int w, int num) {

        int row = (num - 1) / w + 1;    // num의 행 수
        int col = (num - 1) % w + 1;    // 각 층의 시작 위치로 부터 num의 열

        // 짝수층일 때, num의 실제 열
        if (row % 2 == 0) {
            col = w - col + 1;
        }

        int totalRow = (n - 1) / w + 1; // 전체 층수
        int answer = 0;

        // num 위에 몇 칸이 존재하는지 확인
        for (int r = row; r <= totalRow; r++) {

            // 시작 칸과 끝 칸을 구함, 맨 윗층은 끝까지 온전히 존재하지 않을 수 있으므로 min 사용
            int start = (r - 1) * w + 1;
            int end = Math.min(r * w, n);

            int check;

            if (r % 2 == 1) {
                check = start + col - 1;
            } else {
                check = start + (w - col);
            }

            if (check >= start && check <= end) {
                answer++;
            }
        }

        return answer;
    }
}