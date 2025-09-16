import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int init = 1;       // 처음 공이 들어있는 위치
        int m = Integer.parseInt(br.readLine());    // 컵을 바꾼 횟수

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if ((init == x) & (init != y)) {
                init = y;
            } else if ((init == y) & (init != x)) {
                init = x;
            } else init = init;
        }

        System.out.println(init);
    }
}