/**
 * 주어진 방향으로 이동할 때, 공원을 벗어나거나 장애물을 만나면 해당 명령을 무시하고 다음 명령을 수행함
 * 로봇 강아지가 모든 명령을 수행한 후 놓인 위치를 [세로 좌표, 가로 좌표] 배열로 return
 * <p>
 * S는 시작점의 위치, X는 이동할 수 없는 길,
 */

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) =='S') {
                    y = i;
                    x = j;
                }
            }
        }

        for (String route : routes) {
            String[] temp = route.split(" ");

            String dir = temp[0];
            int dist = Integer.parseInt(temp[1]);

            int nx = x;
            int ny = y;

            boolean possible = true;

            // 한 칸씩 이동하며 범위와 장애물 체크
            for (int i = 0; i < dist; i++) {

                if(dir.equals("N")) ny--;
                else if (dir.equals("S")) ny++;
                else if(dir.equals("W")) nx--;
                else nx++;

                if (nx < 0 || ny < 0 || nx >= park[0].length() || ny >= park.length) {
                    possible = false;
                    break;
                }

                if (park[ny].charAt(nx) == 'X') {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{y, x};
    }
}