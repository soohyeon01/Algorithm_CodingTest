import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;   // 0을 입력 받으면 종료

            String str = String.valueOf(num);   // 비교를 위하여 문자열로 변경
            int len = str.length();
            boolean status = true;      // yes, no를 결정하는 스위치

            for (int i = 0; i < len / 2; i++) {
                if (str.charAt(i) != str.charAt(len - i - 1)) {
                    status = false;
                    break;
                }
            }

            if (!status) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }

//        bw.flush();
//        bw.close();
        br.close();
    }
}