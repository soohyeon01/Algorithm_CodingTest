import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3 ; i++) {
            int n = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;

            for (int j = 0; j < n; j++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }
            int compare = (sum.compareTo(BigInteger.ZERO));
            String result = (compare > 0) ? "+" : (compare < 0 ? "-" : "0");
            System.out.println(result);
        }
    }
}