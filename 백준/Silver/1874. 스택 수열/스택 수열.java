import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    /**
     * 팩토리얼의 실제 수를 구하는 방식은 실현 불가(너무 큰 숫자가 들어감)
     * 5가 결국 0을 만드는 구조
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        int comp = 1;
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(br.readLine());

            // comp가 입력받은 수보다 같아질 때 까지 stack 에 push
            while (comp <= input) {
                stack.push(comp);
                comp++;
                sb.append("+\n");
            }

            // 스택이 비어있지 않고, 가장 먼저 꺼내져야 하는 수가 입력받은 값과 같으면 pop, 그렇지 않으면 NO 출력하고 종료
            if (!stack.empty() && stack.peek() == input) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }

        }
            System.out.println(sb);
    }


}
