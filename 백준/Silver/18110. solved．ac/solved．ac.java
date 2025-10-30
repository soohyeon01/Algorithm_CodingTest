import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 난이도 30%(위 아래 15%씩) 절사평균으로 결정/ 사람수, 난이도 반올림
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 아무 의견이 없다면 문제 난이도 0
        if (n == 0) {
            System.out.println(0);
            return;
        }
        // 난이도 배열에 저장
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        /*  직접 버블방식 구현하면 시간초과됨
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        */
        // 위, 아래에서 15% 반올림
        int roundN = (int)Math.round(n * 0.15);
        // 절사평균 구하기
        double sum = 0;
        for (int i = roundN; i < n - roundN; i++) {
            sum += arr[i];
        }
        double result = (sum / (n - roundN * 2L));

        System.out.println(Math.round(result));
    }
}

