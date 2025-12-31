import java.io.*;
import java.util.*;

/**
 * 1764 - 자료구조, 집합과 맵
 * 듣도 보도 못한 사람(ㅋㅋ) 구하기
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());   // 듣 
        int M = Integer.parseInt(st.nextToken());   // 보

        Set<String> set = new HashSet<>(); // 듣도 못한 사람을 먼저 저장
        List<String> list = new ArrayList<>(); // 보도 못한 사람에 또 등장하면 결과 리스트에 저장
        // 듣도 못한 사람 셋에 저장하고
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            set.add(name);
        }
        // 보도 못한 사람과 비교하여 중복되는 사람만 결과 리스트에 저장
        for (int i = 0; i < M; i++) {
            String name = br.readLine();

            if (set.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list); // 사전순 정렬

        sb.append(list.size()).append("\n"); // 듣보잡의 수

        // 명단 출력
        for (String name : list) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
