/**
 * 10초 전으로 이동, 10초 후로 이동, 오프닝 건너뛰기
 * 명령어 입력
 * prev: 10초 전으로 이동, 현재 위치가 10초 미만일 경우 0분 0초 시작점으로 이동
 * next: 10초 후로 이동, 남은 시간이 10초 미만일 경우 동영상의 마지막 위치로 이동
 * 오프닝 건너뛰기: 오프닝 구간에 속해있으면 무조건 op_end로 점프
 * <p>
 * 동영상의 위치를 mm:ss 형식으로 return
 */
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        // 문자열을 초단위로 변경해서 계산
        int lenSecond = toSecond(video_len);
        int posSecond = toSecond(pos);
        int opStart = toSecond(op_start);
        int opEnd = toSecond(op_end);

        // 처음 입력 받은 pos가 오프닝 구간일 경우
        posSecond = skipOpening(posSecond, opStart, opEnd);
        
        for (String command : commands) {
            if (command.equals("next")) {
                posSecond = Math.min(posSecond + 10, lenSecond);
            } else { // 명령어가 "prev" 일 경우
                posSecond = Math.max(posSecond - 10, 0);
            }

            posSecond = skipOpening(posSecond, opStart, opEnd);
        }

        return toTime(posSecond);
    }

    // 오프닝 건너뛰기
    private static int skipOpening(int pos, int opStart, int opEnd) {
        if (opStart <= pos && pos <= opEnd) {
            pos = opEnd;
        }
        return pos;
    }

    private String toTime(int second) {
        int mm = second / 60;
        int ss = second % 60;

        return String.format("%02d:%02d", mm, ss);
    }

    private static int toSecond(String time) {
        String[] split = time.split(":");
        int mm = Integer.parseInt(split[0]);
        int ss = Integer.parseInt(split[1]);

        return mm * 60 + ss;
    }
}