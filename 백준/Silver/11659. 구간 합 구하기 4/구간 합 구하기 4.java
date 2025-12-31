import java.io.*;
import java.util.*;

/**
 * 11659 - 구간합
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        // 원본 배열 저장
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /* 누적합 배열 추가 */
        int[] prefix = new int[N + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1]; // prefix 는 1부터 시작하고, arr 은 0부터 시작함
        }

        // 구간합 구하기
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int ans = prefix[j] - prefix[i - 1]; // i부터 j 까지의 합
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
