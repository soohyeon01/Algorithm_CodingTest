import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /**
     * 브루트포스 알고리즘
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 카드의 개수
        int m = Integer.parseInt(st.nextToken());   // 최대 합
        int ans = 0;
        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum > ans && sum <= m) {
                        ans = sum;
                    }
                }
            }
        }

        System.out.println(ans);

//        bw.flush();
//        bw.close();
//        br.close();
    }
}
