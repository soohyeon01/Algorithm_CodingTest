import java.io.*;
import java.util.*;

/**
 * 7662 - 이중 우선순위 큐
 * Q에 적용될 일련의 연산 -> 이를 처리한 후 최종적으로 Q에 저장된 데이터 중 최댓값과 최솟값을 출력하는 프로그램
 * !! 우선순위 큐 하나만으로 풀 수 없음, 두개로 풀면 꼬임, 중복처리를 위해 트리맵 사용
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // T개의 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            // map 생성
            TreeMap<Integer, Integer> map = new TreeMap<>();

            // map 에 적용할 연산의 개수를 나타내는 정수 k
            int k = Integer.parseInt(br.readLine());

            // k줄에 걸쳐 연산을 나타내는 문자 D,I 와 정수 n이 주어짐
            StringTokenizer st;
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String F = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (F.equals("I")) {
                    funcI(map, n);
                } else {
                    funcD(map, n);
                }
            }

            funcF(map, sb);
        }

        System.out.println(sb);
    }

    private static void funcF(TreeMap<Integer, Integer> map, StringBuilder sb) {
        // 모든 연산을 처리한 후 Q에 남아있는 값 중 최대 최소 값을 출력, 한줄에 출력, 공백으로 구분
        // Q가 비어있다면 EMPTY 출력
        if (map.isEmpty()) {
            sb.append("EMPTY").append("\n");
        } else {
            sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }
    }

    private static void funcI(TreeMap<Integer, Integer> map, int n) {
        // I는 n을 map 에 삽입하는 연산, 동일한 정수 삽입 가능
        map.put(n, map.getOrDefault(n, 0) + 1);
    }

    private static void funcD(TreeMap<Integer, Integer> map, int n) {
        // Q가 비어있다면 D 연산 무시
        if (map.isEmpty()) return;

        // D 1 은 최댓값을 삭제, D -1 은 최솟값을 삭제 , 각 값이 둘 이상인 경우, 하나만 삭제 됨
        // !! 틀린부분 !! : map.pollLastEntry() 를 사용하면 key를 통째로 날려버림
        if (n == 1) {
            int max = map.lastKey();

            // value가 1이면 날리고, 2 이상이면 value--
            if (map.get(max) == 1) {
                map.remove(max);
            } else {
                map.put(max, map.get(max) - 1);
            }

        } else {
            int min = map.firstKey();

            // value가 1이면 날리고, 2 이상이면 value--
            if (map.get(min) == 1) {
                map.remove(min);
            } else {
                map.put(min, map.get(min) - 1);
            }

        }
    }
}
