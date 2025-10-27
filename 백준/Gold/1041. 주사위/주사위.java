import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 똑같은 주사위 N^3개로 정육면체 만들기 -> 각 면의 합이 최소가 되는 경우 찾기
     * 꼭짓점, 모서리, 면에 위치한 주사위에 따라 보이는 면의 개수가 다름
     * (A, F), (C, D), (E, B) 는 마주보는 면이므로 동시에 보일 수 없음 -> 합을 구하지 않아도 됨
     * 필요한 변수: min, max, min2, min3
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final long n = Long.parseLong(br.readLine()); // n^3 개의 주사위
        int[] dice = new int[6];    // 주사위 각 면을 저장할 배열
        // 주사위 각 면의 숫자를 받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        final long corners = 4;    // 3면이 보이는 주사위
        final long edges = 8 * (n - 2) + 4; // 2면이 보이는 주사위
        final long faces = 5 * (n - 2) * (n - 2) + 4 * (n - 2);   // 1면이 보이는 주사위
//        final long none = (n - 2) * (n - 2) * (n - 1);    // 보이지 않는 주사위 (검증용)
        if (n == 1L) {
            int sum = 0;
            for (int i : dice) {
                if (i != max(dice)) {
                    sum += i;
                }
            }
            sb.append(sum);
        } else {
            /*
            // 디버깅용 코드
            System.out.println("n: " + n);
            System.out.println("corners: " + corners);
            System.out.println("edges: " + edges);
            System.out.println("face: " + faces);
            System.out.println("none: " + none);
            System.out.println("calc: " + (corners + edges + faces + none));
            System.out.println("실제 주사위의 개수: " + (int)Math.pow(n,3));
            */

            result = corners * (long) min3(dice)
                    + edges * (long) min2(dice)
                    + faces * (long) min(dice);

            sb.append(result);
        }
        System.out.println(sb);
    }

    private static int min3(int[] dice) {
        int min3 = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (opposite(i, j)) continue;
                for (int k = j + 1; k < 6; k++) {
                    if (opposite(i, k) || opposite(j, k)) continue;
                    int sum = dice[i] + dice[j] + dice[k];
                    if (sum < min3) min3 = sum;
                }
            }
        }
        return min3;
    }

    private static int min2(int[] dice) {
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                // 마주보는 면이면 합 구하기 패스
                if (opposite(i, j)) continue;
                int sum = dice[i] + dice[j];
                if (sum < min2) min2 = sum;
            }
        }
        return min2;
    }

    private static boolean opposite(int i, int j) {
        boolean[][] opp = new boolean[6][6];
        opp[0][5] = opp[5][0] = true;
        opp[2][3] = opp[3][2] = true;
        opp[1][4] = opp[4][1] = true;

        return opp[i][j];

    }

    private static int max(int[] dice) {
        int max = Integer.MIN_VALUE;
        for (int i : dice) {
            if (max < i) max = i;
        }
        return max;
    }

    private static int min(int[] dice) {
        int min = Integer.MAX_VALUE;
        for (int i : dice) {
            if (min > i) min = i;
        }
        return min;
    }
}

