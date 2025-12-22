import java.io.*;
import java.util.*;

/**
 * 11047
 * 가지고 있는 동전 N 종류, 동전을 적절히 섞어 가치의 합을 K로 만들것.
 * -> 이때 필요한 동전 개수의 최솟값은?
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동전의 종류
        int K = Integer.parseInt(st.nextToken()); // 원하는 가치의 합
        int cnt = 0; // 동전의 개수 카운트

        Integer[] values = new Integer[N];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(values, Collections.reverseOrder()); // 내림차순 정렬

        for (int i = 0; i < values.length; i++) {
            while (K >= values[i]) {
                K -= values[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}


