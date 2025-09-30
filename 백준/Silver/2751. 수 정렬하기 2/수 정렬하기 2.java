import java.io.*;
import java.util.Arrays;


public class Main {
    /**
     * 정렬
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        // 출력 형식에 맞춰 출력
        StringBuilder sb = new StringBuilder();
        for (int i : num) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

}