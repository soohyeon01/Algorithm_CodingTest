import java.io.*;

public class Main {
    /**
     * 브루트포스 알고리즘
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;

        int series = Integer.parseInt(br.readLine()); // 입력받은 시리즈
        int init = 666; // 제일 작은 종말의 수
        int cnt = 1;    // loop 안에서 시리즈를 세는 변수

        while (true) {
            if (series == cnt) {    // series 와 cnt 의 값이 같으면 종료
                break;
            }

            init++; // init 값을 하나씩 증가

            if (Integer.toString(init).contains("666")) {
                cnt++;
            }   // init 값에 666이 포함되면 cnt 증가, 비교하기 쉽도록 init 을 문자열로 바꿈
        }

        bw.write(String.valueOf(init));
        bw.flush();
        bw.close();
        br.close();
    }

}
