import java.io.*;
import java.util.StringTokenizer;

final class Pen {
    private final int set;
    private final int piece;

    Pen(int set, int piece) {
        this.set = set;
        this.piece = piece;
    }

    public int set() {
        return set;
    }

    public int piece() {
        return piece;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    // 참가자 수
        int[] arrT = new int[6];    // 티셔츠 사이즈 별 개수를 담을 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arrT[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());   // 티셔츠 묶음 수
        int p = Integer.parseInt(st.nextToken());   // 펜 묶음 수

        int ansT = calcT(arrT, t);
        Pen ansP = calcP(n, p);

        bw.write(ansT + "\n");
        bw.write(ansP.set() + " " + ansP.piece());

        bw.flush();
        bw.close();
        br.close();
    }

    private static Pen calcP(int n, int p) {
        int set = n / p;
        int piece = n % p;
        return new Pen(set, piece);
    }

    private static int calcT(int[] arrT, int t) {
        int cnt = 0; // 총 묶음 수
        for (int i : arrT) {
            cnt += (i + t - 1) / t;
        }
        return cnt;
    }
}
