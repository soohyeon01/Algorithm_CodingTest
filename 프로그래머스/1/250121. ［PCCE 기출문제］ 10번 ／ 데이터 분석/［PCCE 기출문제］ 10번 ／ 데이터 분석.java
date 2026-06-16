import java.util.*;

/**
 * data[][] = {code, date, maximum, remain}
 * ext: 어떤 정보를 기준으로 데이터를 뽑아낼지 (String)
 * val_ext: 뽑아낼 정보의 기준값 (int)
 * sort_by: 정렬할 기준 (String)
 * <p>
 * data 에서 ext 값이 val_ext 보다 작은 데이터만 뽑은 후, sort_by 에 해당하는 값을 기준으로 오름차순으로 정렬
 * <p>
 * ext 와 sort_by 의 값은 code, date, max, remain 중 한가지
 * val_ext 는 ext 에 따라 적절한 숫자로 주어짐
 */

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        // map 으로 key, value 맵핑
        Map<String, Integer> map = Map.of(
                "code", 0,
                "date", 1,
                "maximum", 2,
                "remain", 3
        );

        // ext 값이 val_ext 보다 작은 값만 필터
        List<int[]> list = new ArrayList<>();
        int extIdx = map.get(ext);

        for (int[] arr : data) {
            if (arr[extIdx] < val_ext) {
                list.add(arr);
            }
        }

        // list를 sort_by 를 기준으로 오름차순 정렬 후, 배열로 변경
        int sortIdx = map.get(sort_by);
        list.sort((a, b) -> a[sortIdx] - b[sortIdx]);

        int[][] answer = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

