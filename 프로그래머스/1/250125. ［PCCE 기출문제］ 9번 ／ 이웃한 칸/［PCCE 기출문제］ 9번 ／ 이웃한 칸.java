/**
 * 인접한 칸 중 같은 색깔인 칸 고르기
 */
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        int length = board.length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        for (int i = 0; i < 4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];

            if (x >= 0 && x < length && y >= 0 && y < length) {
                if (board[h][w].equals(board[x][y])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}