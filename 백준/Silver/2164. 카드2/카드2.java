import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
    /**
     * 자료구조 - 큐
     */

    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queue = firstTurn(n);

        // 위의 카드로 맨위는 버리고, 다음장은 맨 뒤로 넣기 반복
        while (queue.size() > 1) {
            queue.pollFirst();
            queue.offerLast(queue.pollFirst());
        }
        System.out.println(queue.peekFirst());
    }

    private static Deque<Integer> firstTurn(int n) {
        // 카드를 버리고 뒤로 보내는 과정을 생각해보면, 이 짝수면 짝수만 남고 홀수면 n + 짝수 만 남음
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                queue.addLast(i);
            }
        }
        // 홀수 일 경우 큐 맨앞에 n을 더해줌
        if (n % 2 != 0) {
            queue.addFirst(n);
        }
        return queue;
    }
}