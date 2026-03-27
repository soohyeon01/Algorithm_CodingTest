import java.io.*;
import java.util.*;

/**
 * 5525 - IOIO
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N (N+1개의 I와 N개의 O이 교대로 나오는 문자열 Pn : 2n + 1)
        int N = Integer.parseInt(br.readLine());

        // S의 길이 M
        int M = Integer.parseInt(br.readLine());

        // S (전체 문자열)
        String S = br.readLine();
/*
        해당 방식을 사용하면 시간초과
        // Pn 생성
        // i가 짝수면 I를 넣고, i 가 홀수면 O를 넣음
        StringBuilder Pn = new StringBuilder();
        for (int i = 0; i < (N * 2 + 1); i++) {
            if (i % 2 == 0) Pn.append("I");
            else Pn.append("O");
        }
*/
        // IOI 중 O를 기준으로 문자열 검사
        int cnt = 0;
        int ans = 0;
        for (int i = 1; i < M - 1; i++) {

            if (S.charAt(i - 1) == 'I' &&
                    S.charAt(i) == 'O' &&
                    S.charAt(i + 1) == 'I') {
                cnt++;

                /*
                 위의 기준으로 IOI 가 N번 나온다는 뜻은
                 S: OOIOIOIOIO -> OO(IOI)OIOIO (cnt + 1) -> OOIO(IOI)OIO (cnt + 2)
                 cnt = N = 2 : OO(IOIOI)OIO -> ans++
                */

                if (cnt == N) {
                    ans++;
                    cnt--;
                }
                /*
                cnt-- 을 해줌으로써
                다음 턴에 OOIO(IOI)OIO (cnt + 1) -> OOIOIO(IOI)O (cnt + 2) => OOIO(IOIOI)O -> ans++
                까지 구할 수 있게 됨
                */

                // 다음 턴에도 O를 가운데 끼고 검사해야하기 때문에
                i++;
                
            } else { // 연결이 되지 않을 경우 cnt 0으로 초기화
                cnt = 0;
            }

        }
        System.out.println(ans);
    }
}

