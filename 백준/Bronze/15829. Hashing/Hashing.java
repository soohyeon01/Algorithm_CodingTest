import java.io.*;
import java.util.*;

public class Main {
    /**
     * 해시함수 구현
     * 'a' - 96 = 1
     */
    public static void main(String[] args) throws IOException {
        final int r = 31;
        final int m = 1234567891;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long hash = 0;   // 최종 해시값을 저장할 변수
        long pow = 1;    // 거듭 제곱의 최초값

        for (int i = 0; i < l; i++) {
            int value = str.charAt(i) - 96;
            hash = (hash + value * pow) % m;
            pow = (pow * r) % m;
        }

        System.out.println(hash);

//        System.out.println(sb);
    }
}
