import java.io.*;
import java.util.*;

/**
 * 18870 - 정렬, 좌표 압축
 * 값의 범위가 크기 때문에, 값 보정으로 접근하면 타임아웃 확률 높아짐
 * value = map.get(key); 방식으로 접근, 배열에는 압축 전 값을 받으므로 map-key 에 압축 전 값을 넣는게 유리할 듯
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 좌표의 개수
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] clone = arr.clone(); // 원본 배열을 유지하고 진행
        Arrays.sort(arr); // arr 배열을 오름차순 정렬

        // 배열 안에 같은 값이 있을 경우, 동차로 가야하기 때문에 배열 인덱스를 map의 값으로 사용하는 것은 부적절 -> index 변수 따로
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], index++);
            }
        }

        // clone 배열을 기준으로 값을 꺼내기
        for (int i : clone) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}


