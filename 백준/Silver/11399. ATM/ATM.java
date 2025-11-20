import java.io.*;
import java.util.*;

/**
 * 11399
 * 그리디 알고리즘
 * 오름차순으로 정렬하여 인출 소요 시간이 큰 사람을 후순위로 보내야 함
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 사람의 수
        int[] times = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times);

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += times[i] * (n - i);
        }

        System.out.println(total);
    }
}