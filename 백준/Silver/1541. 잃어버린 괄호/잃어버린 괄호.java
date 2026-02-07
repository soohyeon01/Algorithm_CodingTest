import java.io.*;
import java.util.*;

/**
 * 1541 - 잃어버린 괄호 (그리디, 파싱)
 * 숫자와 + - 로 이루어진 식에 괄호를 적절히 넣어 최소값 만들기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int ans = 0;

        // 첫번쨰 토큰은 무조건 더해야함
        String first = st.nextToken();
        StringTokenizer first_st = new StringTokenizer(first, "+");
        while (first_st.hasMoreTokens()) {
            ans += Integer.parseInt(first_st.nextToken());
        }

        // - 부호를 기준으로 식을 나누었기 때문에, 이후 토큰 부터는 모두 뺄셈으로 계산
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            StringTokenizer temp_st = new StringTokenizer(temp, "+");

            while (temp_st.hasMoreTokens()) {
                ans -= Integer.parseInt(temp_st.nextToken());
            }
        }
        System.out.println(ans);
    }
}

