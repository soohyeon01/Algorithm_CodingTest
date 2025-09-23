import java.io.*;
import java.util.*;

import static java.util.Collections.*;


public class Main {
    /**
     * 자료 구조 : Set 사용 (value를 비교하여 자료 추가/삭제)
     *            내림차순 정렬: set -> list -> sort
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> members = new HashSet<>();  // 출입 기록 set
        int n = Integer.parseInt(br.readLine());    // 출입 기록 수

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());    // 출입 기록을 읽음
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                members.add(name);
            } else {
                members.remove(name);
            }
        };

        List<String> list = new ArrayList<>(members);
        list.sort(reverseOrder());  // 내림차순 정렬

        for (String s : list) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}