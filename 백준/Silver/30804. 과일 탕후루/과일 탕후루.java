import java.io.*;
import java.util.*;

/**
 * 30804 - 과일 탕후루 (투포인터)
 * N개의 과일이 꽂혀있는 탕후루, 과일의 종류 9가지, 과일 두종류 이하로 사용 가능
 * => 연속된 구간에서 서로 다른 숫자가 2개 이하이면서, 총 개수는 가장 많게
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 꽂혀있는 과일의 개수

        int[] cnt = new int[10]; // 각 과일의 개수
        int[] arr = new int[N]; // 꼬치
        int left = 0;
        int distinct = 0; // 꽃혀있는 과일의 종류 (조건 판단)
        int total = 0; // 총 꽂혀있는 과일의 개수(최대 과일의 수)

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int right = 0; right < N; right++) {

            arr[right] = Integer.parseInt(st.nextToken()); // 꼬치에 과일 꽂기

            if (cnt[arr[right]] == 0) distinct++; // 처음 들어온 과일이면 과일의 종류++
            cnt[arr[right]]++; // 해당 과일의 개수++

            // 과일의 종류가 2개를 초과하면 앞 쪽에서부터 과일 빼기
            while (distinct > 2) {
                cnt[arr[left]]--;
                if (cnt[arr[left]] == 0) distinct--;
                left++; // 맨 앞에서 부터 한칸씩 뒤로 이동
            }

            total = Math.max(total, right - left + 1);
        }

        System.out.println(total);
    }
}

