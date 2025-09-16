import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 즉시 출력하는 방법말고, 스트링빌더로 한번에 모아서 출력하기

        int n = Integer.parseInt(br.readLine());

        String star = "*";

        for (int i = 1; i < n + 1; i++) {
            for (int k = 0; k < n - i; k++) {
                sb.append(" ");
//                System.out.printf(" ");
            }
            for (int j = 0; j < (2 * i - 1); j++) {
                sb.append(star);
//                System.out.print(star);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}