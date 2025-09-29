import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /**
     * 유클리드 호제법
     * - 최대공약수를 빠르고 간단하게 구하는 방법
     * - 큰 수를 작은 수로 나눠서 나머지를 반복적으로 구하다가, 나머지가 0이 되는 순간의 나누는 수가 최대 공약수가 됨
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gdc(a, b));
        System.out.println(lcm(a, b));
    }

    static int gdc(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;   // 최대공약수를 return
    }

    static int lcm(int a, int b) {
        return (a * b) / gdc(a, b);
    }
}



