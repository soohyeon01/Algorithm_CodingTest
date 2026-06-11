import java.util.Arrays;

/**
 * 깔 수 있는 가장 큰 돗자리 한 변의 길이를 return
 * 아무 돗자리도 깔 수 없는 경우 -1 return
 */
class Solution {
    public int solution(int[] mats, String[][] park) {

        // 가장 큰 돗자리부터 검증
        Arrays.sort(mats);

        for (int i = mats.length - 1; i >= 0; i--) {

            int size = mats[i];

            if (canPicnic(park, size)) {
                return size;
            }
        }

        return -1;
    }

    private static boolean canPicnic(String[][] park, int size) {
        int row = park.length;
        int col = park[0].length;

        for (int r = 0; r <= row - size; r++) {
            for (int c = 0; c <= col - size; c++) {

                boolean flag = true;

                for (int j = r; j < r + size; j++) {
                    for (int k = c; k < c + size; k++) {

                        // 빈자리가 아니면 false로 전환
                        if (!park[j][k].equals("-1")) {
                            flag = false;
                            break;
                        }
                    }

                    // 불가능한 상황이 생기면 바로 빠져나옴
                    if (!flag) {
                        break;
                    }
                }

                // 가능한 가장 큰 지역을 찾으면 빠져나옴
                if (flag) {
                    return true;

                }
            }
        }

        return false;
    }

}