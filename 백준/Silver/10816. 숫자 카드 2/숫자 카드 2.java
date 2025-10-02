import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    /**
     * 정렬, 해시 집합
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());    // 가지고 있는 카드의 개수
        Map<Integer, Integer> cards = new HashMap<>();  // 가지고 있는 카드를 저장할 해시맵

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            // 숫자를 하나씩 받아서 map에 존재하지 않는 키면 value 0으로 설정, 이미 존재하는 키면 value + 1
            int num = Integer.parseInt(st.nextToken());
            cards.put(num, cards.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (m-- > 0) {
            int com = Integer.parseInt(st.nextToken());
            sb.append(cards.getOrDefault(com, 0)).append(" ");
        }

        System.out.println(sb);

    }
}
