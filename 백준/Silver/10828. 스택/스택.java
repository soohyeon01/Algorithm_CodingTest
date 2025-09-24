import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    /**
     * 자료구조 - stack
     * + 자바에서 stack 클래스는 오래된 vector 기반이라 현재는 잘 안씀
     *   대신 deque 을 스택/큐 처럼 사용함
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Deque<Integer> stack = new ArrayDeque<>();
        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        bw.write(String.valueOf(-1));
                    } else bw.write(String.valueOf(stack.pop()));
                    bw.newLine();
                    break;

                case "size":
                    bw.write(String.valueOf(stack.size()));
                    bw.newLine();
                    break;

                case "empty":
                    bw.write(stack.isEmpty() ? String.valueOf(1) : String.valueOf(0));
                    bw.newLine();
                    break;

                case "top":
                    if (!stack.isEmpty()) {
                        bw.write(String.valueOf(stack.peek()));
                    } else bw.write(String.valueOf(-1));
                    bw.newLine();
                    break;
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

}
