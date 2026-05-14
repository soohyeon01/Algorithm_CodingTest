import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    static final int INF = 1_000_000_000;

    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        int[][] desertMap = new int[m][n];
        // 비를 안맞는 구역 -> 가장 늦게 맞는 구역 순으로 우선순위
        for (int i = 0; i < m; i++) {
            Arrays.fill(desertMap[i], INF);
        }

        // map 배열에 drop 순서 저장
        for (int i = 0; i < drops.length; i++) {
            int row = drops[i][0];
            int col = drops[i][1];

            desertMap[row][col] = i + 1;
        }

        // 슬라이딩 윈도우
        // 가장 작은 값이 가장 큰 구역이 선인장 구역이 됨

        // 가로 슬라이딩
        int[][] rowMin = new int[m][n - w + 1];
        for (int r = 0; r < m; r++) {

            // 인덱스를 저장하는 데크 생성
            Deque<Integer> dq = new ArrayDeque<>();

            for (int c = 0; c < n; c++) {

                // 인덱스를 비교하여 범위를 벗어난 값 제거
                while (!dq.isEmpty() && dq.peekFirst() <= c - w) {
                    dq.pollFirst();
                }

                // 실제 값끼리 비교하여 현재값보다 크면 제거
                while (!dq.isEmpty() && desertMap[r][dq.peekLast()] >= desertMap[r][c]) {
                    dq.pollLast();
                }

                dq.offerLast(c);

                if (c >= w - 1) {
                    rowMin[r][c - w + 1] = desertMap[r][dq.peekFirst()];
                }
            }
        }

        // 세로 슬라이딩
        int[][] finalMin = new int[m - h + 1][n - w + 1];
        for (int c = 0; c < n - w + 1; c++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int r = 0; r < m; r++) {

                while (!dq.isEmpty() && dq.peekFirst() <= r - h) {
                    dq.pollFirst();
                }

                while (!dq.isEmpty() && rowMin[dq.peekLast()][c] >= rowMin[r][c]) {
                    dq.pollLast();
                }

                dq.offerLast(r);

                if (r >= h - 1) {
                    finalMin[r - h + 1][c] = rowMin[dq.peekFirst()][c];
                }
            }
        }

        // 최종 값 찾기
        int result = -1;
        int ansR = 0;
        int ansC = 0;

        for (int r = 0; r < m - h + 1; r++) {
            for (int c = 0; c < n - w + 1; c++) {
                if (finalMin[r][c] > result) {
                    result = finalMin[r][c];

                    ansR = r;
                    ansC = c;
                }
            }
        }

        return new int[]{ansR, ansC};
    }
}