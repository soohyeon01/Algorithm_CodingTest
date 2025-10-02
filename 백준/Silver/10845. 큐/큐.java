import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    /**
     * 큐 직접 구현
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());    // 입력 받을 명령어 개수
        int[] queue = new int[10001];   // back 인덱스를 구현하기 위해 10000 +1 개의 원소를 가진 배열로 생성
        int front = 0, back = 0;    // 큐를 구현하기 위한 인덱스 두개

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            // push일 경우에만 split 필요
            if (command.startsWith("push")) {
                int input = Integer.parseInt(command.split(" ")[1]);
                queue[back] = input;
                back++;
            } else {
                switch (command) {
                    case "pop":
                        if (front == back) {    // empty check
                            sb.append(-1).append("\n");
                        } else {    // 출력수 front 인덱스 +1 하여 다음 pop 시 front + 1 값을 참조 할 수 있도록 함
                            sb.append(queue[front]).append("\n");
                            front++;
                        }
                        break;

                    case "size":
                        sb.append(back - front).append("\n");
                        break;

                    case "empty":
                        if (front == back) {
                            sb.append(1).append("\n");
                        } else sb.append(0).append("\n");
                        break;

                    case "front":
                        if (front == back) {
                            sb.append(-1).append("\n");
                        } else sb.append(queue[front]).append("\n");
                        break;

                    case "back":
                        if (front == back) {
                            sb.append(-1).append("\n");
                        } else sb.append(queue[back-1]).append("\n");
                        break;
                }
            }
        }

        System.out.println(sb);
    }
}
