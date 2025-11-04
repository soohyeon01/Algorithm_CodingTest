import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    /**
     * 스택을 사용해서 짝을 맞춰야하는 문제
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            // 종료 규칙
            if (input.equals(".")) break;
            
            // 스택에 괄호를 담아서 짝을 맞춤
            Stack<Character> stack = new Stack<>();
            boolean check = true;

            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        check = false;
                        break;
                    }
                    stack.pop();    // 괄호의 짝이 맞지 않으면 check = false, 짝이 맞으면 괄호 pop하고 check = true 유지
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }
            // check = true로 유지되어있고, stack의 모든 괄호가 짝을 맞춰 나갔으면 yes / 둘 중 하나라도 만족하지 않는다면 no
            if (check && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

