import java.io.*;
import java.util.*;

public class Main {
    /**
     * 통계학
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 산술평균
        sb.append(avg(arr)).append("\n");

        // 중앙값
        sb.append(middle(arr)).append("\n");

        // 최빈값
        sb.append(freq(arr)).append("\n");

        // 범위
        sb.append(diff(arr)).append("\n");

        System.out.println(sb);
    }

    private static int diff(int[] arr) {
        Arrays.sort(arr);

        return arr[arr.length - 1] - arr[0];
    }

    private static int freq(int[] arr) {

        // 빈도수 map에 저장
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // map에서 최대 value 구하기
        int max = 0;
        for (int value : map.values()) {
            if (value > max) {
                max = value;
            }
        }

        // 최빈값 구하기 ( 여러개면 두번째로 작은 수)
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int key : map.keySet()) {
            int cnt = map.get(key);

            if (cnt == max) {

                if (key < first) {
                    second = first;
                    first = key;
                } else if (key < second) {
                    second = key;
                }
            }
        }
        
        // second 값이 변하지 않았다면 그냥 최빈값을 출력, second 값이 변했다면 두번째로 작은 값 출력
        if (second ==  Integer.MAX_VALUE) return first;
        return second;
    }

    private static int middle(int[] arr) {
        int mid = arr.length / 2;
        Arrays.sort(arr);

        return arr[mid];
    }

    private static int avg(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = (double) sum / arr.length;
        return (int) Math.round(avg);
    }
}
