import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String star = "*";

        for (int i = 1; i < n + 1; i++) {
            for (int k = 0; k < n - i; k++) {
                System.out.printf(" ");
            }
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print(star);
            }
            System.out.println();
        }
    }
}