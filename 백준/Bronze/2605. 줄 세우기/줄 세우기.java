import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;


public class Main {
    /**
     * 자료 구조 : ArrayList.add() 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    // 학생의 수
        StringTokenizer st = new StringTokenizer(br.readLine());    // 입력된 숫자들을 읽음

        List<Integer> line = new ArrayList<>();    // 줄 세울 리스트 생성

        for (int i = 1; i <= n; i++) {
            int pick = Integer.parseInt(st.nextToken());    // i번째 학생이 뽑은 번호
            line.add(line.size() - pick, i);    // 뽑은 숫자 만큼 앞당겨서 세워줌
        }

        for (Integer i : line) {
            bw.write(i + " ");  // 출력 형식 지정
        }

        bw.flush();
        bw.close();
        br.close();

    }
}