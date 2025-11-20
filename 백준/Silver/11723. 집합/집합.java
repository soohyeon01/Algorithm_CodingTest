import java.io.*;
import java.util.*;

/**
 * 11723
 * 비트마스킹
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine()); // 수행해야 하는 연산의 수
        int bit = 0; // 비트 마스킹을 위해 필요한 변수(int = 4byte = 32bit)

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if (command.equals("add") || command.equals("remove") || command.equals("check") || command.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
            }

            if (command.equals("add")) {
                bit |= (1 << num);
            } else if (command.equals("remove")) {
                bit &= ~(1 << num);
            } else if (command.equals("check")) {
                if ((bit & (1 << num)) != 0) {
                    sb.append("1\n");
                } else sb.append("0\n");
            } else if (command.equals("toggle")) {
                bit ^= (1 << num);
            } else if (command.equals("all")) {
                bit = (1 << 21) - 1;
            } else if (command.equals("empty")) {
                bit = 0;
            }
        }
        System.out.println(sb);
    }
}

