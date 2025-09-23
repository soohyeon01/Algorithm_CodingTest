import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.*;


public class Main {
    /**
     * 수학 문제로 접근
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 여학생
        int M = Integer.parseInt(st.nextToken());   // 남학생
        int K = Integer.parseInt(st.nextToken());   // 인턴

        int team = min(N / 2, M);   // 인턴 고려하지 않으면 인원이 작은 쪽에 맞춰서 팀 구성 -> 최대 팀의 수

        /*
        * 팀을 이루기 위해 필요한 3명, 반드시 필요한 인턴 k명이 학생 전체의 수 보다 작아야 팀을 구성할 수 있다.
        * M + N >= K + 3  ->  M + N - K >= 3  ->  (M + N - K) / 3 >= 1
        * 위의 조건을 만족하지 않으면 팀을 구성할 수 없다.
        * 위의 조건에 부합하는 팀의 수를 구하고, 인턴을 고려하지 않고 구한 팀의 수 중 작은 값은 최대의 팀 수로 한다.
        * */
        team = min((M + N - K) / 3, team);

        System.out.println(team);
    }
}