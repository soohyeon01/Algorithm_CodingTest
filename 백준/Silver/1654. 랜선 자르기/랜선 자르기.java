import java.io.*;
import java.util.*;

/**
 * 1654 - 랜선 자르기(이분 탐색)
 * 기존에 가지고 있는 K개의 길이가 다른 랜선을 잘라서, 길이가 같은 랜선 N개를 만들 때
 * 만들 수 있는 랜선의 길이의 최댓값
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 현재 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 만들고 싶은 랜선의 개수

        long[] lengthK = new long[K]; // 가지고 있는 랜선의 길이
        long max = 0; // 이분 탐색을 위해 가지고 있는 랜선 중 가장 긴 랜선을 저장

        // 랜선의 길이 배열에 저장
        for (int i = 0; i < lengthK.length; i++) {
            lengthK[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lengthK[i]); // max에 저장되어 있는 값과 새로 받은 값을 비교하여 가장 큰 값을 저장
        }

        System.out.println(getAns(max, lengthK, N));

    }

    private static long getAns(long max, long[] lengthK, int N) {
        long low = 1; // 이분탐색을 위해 가장 작은 값을 지정
        long high = max;
        long ans = 0; // N개에 맞춰 만들 수 있는 가장 긴 길이의 랜선

        while (low <= high) {
            long mid = (low + high) / 2; // 이분탐색 시작

            long cnt = 0;
            for (long length : lengthK) {
                cnt += (length / mid);
            }

            if (cnt >= N) {
                ans = mid;
                low = mid + 1; // mid  값으로 랜선을 잘랐을 때, 개수가 N보다 많다면 최소값을 mid로 올리고 ans에는 mid값을 저장
            } else {
                high = mid - 1; // 개수가 N 보다 적다면 high 값을 mid -1 로 조정
            }
        }
        return ans;
    }
}

