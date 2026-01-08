import java.io.*;
import java.util.*;

/**
 * 1927 - 최소 힙, 우선순위 큐
 * 만약 배열을 만들어서 수가 들어올 떄마다 정렬한다면 시간초과
 * java.util.PriorityQueue
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 연산의 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(x);
            }
        }
        System.out.println(sb);
    }
}