import java.io.*;
import java.util.*;

/**
 * 17219 - 비밀번호 찾기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사이트 주소의 수
        int M = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수

        Map<String, String> map = new HashMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        while (M-- > 0) {
            String input = br.readLine();
            String ans = map.get(input);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}

