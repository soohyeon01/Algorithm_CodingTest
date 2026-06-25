/**
 * 파일을 한번에 삭제하기 위한 최소한의 이동거리를 갖는 드래그의 시작점과 끝점을 담은 정수 배열 return
 * [lux, luy, rdx, rdy]
 */

class Solution {
    public int[] solution(String[] wallpaper) {

        // 시작점은 파일이 존재하는 칸 중 가장 작은 x값과 y값의 조합, 끝점은 가장 큰 x값과 y값의 조합

        int row = wallpaper.length;
        int col = wallpaper[0].length();

        int[] min = new int[]{row, col};
        int[] max = new int[]{0, 0};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    min[0] = Math.min(i, min[0]);
                    min[1] = Math.min(j, min[1]);

                    max[0] = Math.max(i, max[0]);
                    max[1] = Math.max(j, max[1]);
                }
            }
        }

        return new int[]{min[0], min[1], max[0] + 1, max[1] + 1};
    }
}
