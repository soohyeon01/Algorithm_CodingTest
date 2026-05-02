import java.util.Map;

class Solution {

    // Map 구조를 사용하는 것이 명확하게 관계를 드러낸다 생각하여 선택함
    
    public int solution(String s) {

        // map 구조로 숫자와 문자를 짝지어서 대체하는 방법 고안
        Map<String, Integer> map = Map.of(
                "zero",0,
                "one", 1,
                "two", 2,
                "three",3,
                "four",4,
                "five",5,
                "six", 6,
                "seven",7,
                "eight",8,
                "nine",9
        );

        // map을 순회하면서 문자열에 포함된 key 값을 value로 대체
        for (String key : map.keySet()) {
            s = s.replace(key, String.valueOf(map.get(key)));
        }

        // 결과를 정수로 변환하여 return
        return Integer.parseInt(s);
    }
}
