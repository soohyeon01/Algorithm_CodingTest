import java.io.*;
import java.util.*;

/**
 * 11279 - 최대 힙
 * 배열에 자연수 x를 넣음. 0을 입력한 만큼 가장 큰 수 출력, 배열이 비어있으면 0을 출력
 * 우선순위 큐는 작은 수 부터 정렬되므로, 큰 수를 뽑게 하기 위해서는 입력 받은 수를 음수로 저장하고,
 * 출력할 때는 다시 - 부호를 붙여 원래의 수로 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(-pq.poll()).append("\n");
                }
            } else {
                pq.add(-x);
            }
        }
        System.out.println(sb);
    }
}

