import java.util.*;

// 각 약관마다 유효기간이 정해져있음
// 어떤 약관으로 수집 됐는지 파악하여, 유효기간이 지난 정보는 파기
// 오늘 날짜로 파기해야 할 개인정보 번호를 구하라 (단, 모든 달이 28일까지 있다고 가정)
// 파기해야 할 개인정보 번호를 오름차순으로 1차원 배열에 담아 return

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        // 모든 달이 28일까지 있다고 가정하므로 total = year*12*28 + month*28 + day 형태로 환산
        int todayDay = yearToday(today);

        // 편리성을 위해 terms를 map 형태로 전환
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            arrToMap(term, map);
        }


        // privacies의 원소에서 날짜와 약관종류를 분리하여 최종적으로 비교
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            int expireDay = yearToday(temp[0]) + map.get(temp[1]); // 수집된 날짜 + 약관별 유효기간

            // 파기해야 할 개인정보를 리스트에 담음
            if (expireDay <= todayDay) {
                list.add(i +1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private static int yearToday(String today) {
        String[] todayTemp = today.split("\\.");
        int todayY = Integer.parseInt(todayTemp[0]);
        int todayM = Integer.parseInt(todayTemp[1]);
        int todayD = Integer.parseInt(todayTemp[2]);

        return (todayY * 12 * 28) + (todayM * 28) + todayD;
    }

    private static void arrToMap(String term, Map<String, Integer> map) {
        String[] temp = term.split(" ");
        map.put(temp[0], Integer.parseInt(temp[1]) * 28);
    }
}