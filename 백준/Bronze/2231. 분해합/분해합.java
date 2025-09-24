import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 브루트포스 알고리즘
     * 1 <= M <= N : 가능한 M의 범위
     * 어떤 수의 각 자리 최대 합은 (9 * 자릿수)
     * 최대 M의 범위는 M <= N - (9 * 자릿수)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
        int n = Integer.parseInt(br.readLine().trim());

        int digit = String.valueOf(n).length(); // 자릿수를 구함
        int start = Math.max(1, n - 9 * digit); // 작은 숫자일 경우, 음수 방지

        for (int i = start; i < n; i++) {
            int sum = i;    // 자기자신 값으로 분해합 시작
            int num = i;    // 계산에 쓰일 변수
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }   // 각 자리를 쪼개서 분해합을 구함
            if (sum == n) {
                System.out.println(i);
                return; // 프로그램 종료
            }
        }

        System.out.println(0); // 생성자가 없는 경우 0 출력

//        bw.flush();
//        bw.close();
//        br.close();
    }
}
