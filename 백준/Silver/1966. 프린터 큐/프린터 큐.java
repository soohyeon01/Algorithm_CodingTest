import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 자료구조 - 큐
     * 필요한 변수: 문서의 처음 인덱스, 중요도, 최종 몇번째로 출력되는지
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 테스트 케이스의 수

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // 문서의 개수
            int b = Integer.parseInt(st.nextToken());   // 몇번째로 인쇄되었는지 궁금한 문서
            Queue<Doc> docs = new LinkedList<>();
            int print = 0;  // 몇번째로 출력되었는지 카운트 할 변수


            st = new StringTokenizer(br.readLine());    // 문서의 중요도 한 줄을 읽음
            for (int i = 0; i < a; i++) {
                int priority = Integer.parseInt(st.nextToken());
                docs.add(new Doc(i, priority)); // 문서의 인덱스와 중요도 큐에 저장
            }

            while (!docs.isEmpty()) {
                Doc pick = docs.poll(); // 맨 앞에 있는 문서를 뽑음

                boolean higher = false;     // 컬렉션을 순회하는 와중에 컬렉션을 변경할 수 없기 때문에 스위치를 만들고 for-each 문을 종료시킴
                
                for (Doc doc : docs) {
                    if (pick.priority < doc.priority) { // 맨 앞의 문서와 나머지의 우선순위를 비교
                        higher = true;  // 높은 쪽이 발견되면 스위치를 true 로 바꾸고 종료
                        break;
                    }
                }

                if (higher) {
                    docs.add(pick);
                } else {    // 위의 for-loop 에서 중요도가 더 높은 문서를 찾지 못하고 나왔다면 프린트
                    print++;   
                    if (pick.index == b) {      // 현재 프린트한 문서가 내가 알고 싶었던 문서라면?
                        bw.write(print + "\n");
                        break;
                    }
                }
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Doc {
        int index;  // 문서의 처음 인덱스
        int priority;   // 문서의 중요도

        public Doc(int index, int priority) {   // 큐에 넣을 정보
            this.index = index;
            this.priority = priority;
        }
    }
}