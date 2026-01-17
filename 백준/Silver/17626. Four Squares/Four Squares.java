import java.io.*;
import java.util.*;

/**
 * 17626 - four squares
 * 자연수 n이 주어질 때, n을 최소 개수의 제곱합으로 표현
 * 문제에서 주어진 규칙에 근거하여 최대 답은 4, 완전제곱인 경우 무조건 1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // ans = 1
        if (isSquare(n)) {
            System.out.println(1);
            return;
        }

        // ans = 2
        for (int i = 1; i * i <= n; i++) {
            int rest = n - i * i;
            if (isSquare(rest)) {
                System.out.println(2);
                return;

            }
        }

        // ans = 3
        for (int i = 1; i * i <= n; i++) {
            int rest = n - i * i;
            for (int j = 1; j * j <= rest; j++) {
                int rest_2 = rest - j * j;
                if (isSquare(rest_2)) {
                    System.out.println(3);
                    return;
                }
            }
        }

        // ans = 4 (문제에 근거하여 최대 답은 4)
        System.out.println(4);
    }

    static boolean isSquare(int a) {
        int sqrt = (int) Math.sqrt(a);
        return a == sqrt * sqrt;
    }
}

