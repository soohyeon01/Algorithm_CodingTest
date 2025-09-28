import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    /**
     * 자료구조 - 스택
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());  // 입력받을 괄호 문자열의 개수

        for (int i = 0; i < num; i++) {
            String ps = br.readLine().trim();

            Deque<Character> stack = new ArrayDeque<>();    // 매 라인마다 스택 새로 생성
            boolean check = true;   // 중간 실패 여부 스위치

            for (int j = 0; j < ps.length(); j++) {
                char ch = ps.charAt(j);

                if (ch == '(') {
                    stack.push(ch); // 여는 괄호일 경우 push
                } else if (ch == ')') {
                    if (stack.isEmpty()) {
                        check = false;  // 스택이 비어있으면 NO
                        break;
                    }
                    stack.pop(); // 닫는 괄호일 때, 스택이 비어있지 않으면 pop
                }
            }

            // 스택이 비어있고, 스위치가 ture 인 경우에만 YES 출력, 나머지 경우는 모두 NO
            if (stack.isEmpty() && check) {
                bw.write("YES\n");
            } else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}


