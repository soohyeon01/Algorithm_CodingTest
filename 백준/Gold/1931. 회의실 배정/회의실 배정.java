import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 최대 회의 수를 구하는 문제 -> 회의가 빨리 끝나는 순서대로 정렬
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];   // 회의 시간 저장 배열

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간 순으로 오름차순 정렬, 끝나는 시간이 같다면 시작 시간으로 오름차순 정렬
        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        // 가능한 회의 수 카운팅
        int cnt = 1;
        // 직전 회의의 종료시간을 담는 변수
        int previous = time[0][1];

        // 다음 회의의 시작시간이 전 회의의 끝나는 시간보다 클 때, 가능한 회의 수 증가
        for (int i = 1; i < n; i++) {
            if (previous <= time[i][0]) {
                cnt++;
                previous = time[i][1];
            }
        }
        System.out.println(cnt);
    }
}