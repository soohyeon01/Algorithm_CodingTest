import java.io.*;
import java.util.StringTokenizer;


public class Main {
    /**
     * String.contains() 를 사용하여 풀이
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean find = false;   // 요원 유무를 판단하는 변수
        
        for (int i = 1; i < 6; i++) {
            String name = br.readLine();    // 이름을 한줄씩 받음
            if (name.contains("FBI")) {  // FBI 요원인지 판단
                bw.write(i + " ");  // 오름차순으로 몇번째에 있는 출력
                find = true;    // 요원을 찾으면 true로 변경
            }
        }
        
        // 요원이 한명도 없으면 해당 문자열 출력
        if (!find) {  
            bw.write("HE GOT AWAY!");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}