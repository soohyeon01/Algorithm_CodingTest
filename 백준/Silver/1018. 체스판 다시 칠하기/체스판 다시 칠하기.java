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

        // 체스판의 크기가 (8x8)로 정해져있음
        // 체스판의 경우의 수는 딱 두가지
        String[] white = {
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW"
        };

        String[] black = {
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
        };

        // 입력받은 체스판의 크키
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 입력 받은 체스판
        String[] inputArr = new String[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = br.readLine().trim();
        }

        // 최소값을 저장할 변수, 초기값을 큰 수로 설정하고 loop 안에서 줄여나가는 방식
        int ans = Integer.MAX_VALUE;

        // 입력받은 체스판 위에 (8x8) 체스판을 옮기면서 비교할 수 있는 범위
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int diffWhite = 0;  // white 체스판 비교 변수
                int diffBlack = 0;  // black 체스판 비교 변수

                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if (inputArr[i + x].charAt(j + y) != white[x].charAt(y)) diffWhite++;
                        if (inputArr[i + x].charAt(j + y) != black[x].charAt(y)) diffBlack++;
                    }
                }

                int diff = Math.min(diffWhite, diffBlack);
                ans = Math.min(diff, ans); 
            }
        }
        System.out.println(ans);

//        bw.flush();
//        bw.close();
//        br.close();
    }
}