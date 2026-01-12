import java.io.*;
import java.util.*;

/**
 * 1620 - 포켓몬 도감
 * 도감에는 포켓몬 이름을 저장함.
 * 입력으로 숫자를 받으면 해당 순서의 포켓몬 이름을 출력, 이름을 받으면 순서를 출력
 * Map 구조는 기본적으로  Key -> Value 지원하지만, Value -> Key 지원 안함
 * 시간상 두개의 맵을 만들어 양방향 맵 처럼 사용하는 것이 유리함
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 도감에 수록된 포켓몬 수
        int M = Integer.parseInt(st.nextToken()); // 내가 맞춰야 하는 문제

        Map<Integer, String> iToS = new HashMap<>();
        Map<String, Integer> sToI = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine(); // 포켓몬이름 받기
            iToS.put(i + 1, name); // 도감에 저장
            sToI.put(name, i + 1);
        }

        while (M-- > 0) {
            String inputString = br.readLine();

            if (inputString.charAt(0) > '0' && inputString.charAt(0) <= '9') { // 입력이 숫자로 시작하면 이름을 출력
                int inputInteger = Integer.parseInt(inputString);
                String ans = iToS.get(inputInteger);
                sb.append(ans).append("\n");
            } else {
                int ans = sToI.get(inputString);
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }
}