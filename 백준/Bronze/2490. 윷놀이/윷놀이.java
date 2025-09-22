import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        BufferedWriter bw;
        StringBuilder sb;
        StringTokenizer st;

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();


        for (int i = 0; i < 3; i++) {
            int zero = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                String token = st.nextToken();
                if (token.equals("0")) zero++;
            }
            if (zero == 1) {
                sb.append("A");
            } else if (zero == 2) {
                sb.append("B");
            } else if (zero == 3) {
                sb.append("C");
            } else if (zero == 4) {
                sb.append("D");
            } else {
                sb.append("E");
            }
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();
    }
}