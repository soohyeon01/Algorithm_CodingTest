    import java.io.*;

    public class Main {
        /**
         * 팩토리얼의 실제 수를 구하는 방식은 실현 불가(너무 큰 숫자가 들어감)
         * 5가 결국 0을 만드는 구조
         */
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;    // 5의 개수를 세는 변수

            for (int i = 1; i <= n; i++) {
                int temp = i;
                while (temp % 5 == 0) { // 5의 배수라면 계속 나눔
                    cnt++;
                    temp /= 5;
                }
            }
            System.out.println(cnt);
//            System.out.println(sb);
        }


    }
