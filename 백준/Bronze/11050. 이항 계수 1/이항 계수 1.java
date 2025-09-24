import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /**
     * 이항계수: N개의 원소 중에서 K개를 뽑는 조합의 수
     * => N! / (K! * (N - K)!)
     * 해당 문제의 경우 주어지는 수의 범위가 작아서 팩토리얼을 그대로 계산 가능
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K || K == 0) {   // 분자가 0이 되는 것을 막기 위해, 두 수가 같거나 K가 0이면 1 출력하고 return
            System.out.println(1);
            return;
        }

        int ans = factorial(N) / (factorial(K) * (factorial(N - K)));
        System.out.println(ans);

//        bw.flush();
//        bw.close();
        br.close();
    }

    // 팩토리얼 계산을 여러번 해야하기 때문에 별도의 메소드로 뺌
    private static int factorial(int num) {
        for (int i = num - 1; i > 0; i--) {
            num *= i;}
        return num;
    }
}
