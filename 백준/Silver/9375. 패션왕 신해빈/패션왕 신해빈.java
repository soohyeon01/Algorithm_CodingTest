import java.io.*;
import java.util.*;

/**
 * 9375 - 패션왕
 * 같은 종류의 의상은 하나만 입을 수 있고, 한번 사용한 조합은 다시 사용 못함
 * 조합을 계산하는 문제이므로 map에 종류별로 카운트하여, 종류와 개수를 저장하는 방법 사용
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 의상의 수
            Map<String, Integer> closet = new HashMap<>(); // 의상의 이름은 저장하지 않고, 의상의 종류와 그의 개수를 카운팅해서 저장

            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // name
                String type = st.nextToken();
                closet.put(type, closet.getOrDefault(type, 0) + 1);
            /*
              int a = getOrDefault():closet 안에 해당 type이 있으면 해당 value 반환, 없으면 0 반환 -> 기본 동작 원리
              closet.put(type, a + 1):value a를 가져와 + 1 을 해서 다시 closet에 넣어주는 코드
            */
            }

            int ans = 1;
            for (Integer cnt : closet.values()) {
                ans *= (cnt + 1); // 종류별로 한가지씩 고를 수 있고 + 안고를 수도 있음
            }
            ans -= 1; // 모든 타입의 옷을 하나도 안고르는 조합을 제거

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}

