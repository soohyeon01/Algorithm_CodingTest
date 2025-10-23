import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person {
    int weight;
    int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}
public class Main {
    /**
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Person[] personArr = new Person[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            Person person = new Person(weight, height);
            personArr[i] = person;
        }

        for (int i = 0; i < n; i++) {
            int rank = 0;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                // 몸무게와 키가 모두 커야 덩치가 크다고 판단함
                if ((personArr[i].weight < personArr[j].weight) && (personArr[i].height < personArr[j].height)) {
                    rank++;
                }
            }
            sb.append(rank + 1).append(" ");
        }
        System.out.println(sb);
    }
}

