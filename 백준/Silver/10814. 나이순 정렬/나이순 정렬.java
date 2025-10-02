import java.io.*;
import java.util.*;

class Member {
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
    /**
     * 정렬, 집합
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());    // 가입한 사람의 수

        List<Member> list = new ArrayList<>();
        
        // 리스트에 객체 저장
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(age, name));
        }
        
        // 정렬
        list.sort((a, b) -> a.age - b.age);
        
        // 출력
        for (Member m : list) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }

        System.out.println(sb);

    }
}
