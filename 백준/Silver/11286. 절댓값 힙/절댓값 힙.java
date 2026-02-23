import java.io.*;
import java.util.*;

/**
 * 11286 - 절댓값 힙
 * 0을 입력하면 절댓값이 가장 작은 수를 출력, 절댓값이 같으면 가장 작은 수를 출력
 * 배열이 비어있다면 0을 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 연산의 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (Math.abs(a) == Math.abs(b)) {
                        return a - b; // 절댓값이 같으면 더 작은 수 먼저 저장
                    }
                    return Math.abs(a) - Math.abs(b); // 절댓값이 더 작은 수 먼저 저장
                }
        );

        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(input);
            }
        }

        System.out.println(sb);
    }
}

