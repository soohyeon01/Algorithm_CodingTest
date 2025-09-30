import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    /**
     * 해시셋
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> setA = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            setA.add(Integer.valueOf(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (setA.contains(temp)) {
                bw.write(1 + "\n");
            } else bw.write(0 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
