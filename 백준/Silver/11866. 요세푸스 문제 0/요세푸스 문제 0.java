    import java.io.*;
    import java.util.*;
    
    public class Main {
        /**
         * 큐
         */
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
    
            String line = br.readLine();
            int n = Integer.parseInt(line.split(" ")[0]);   // n 명의 사람
            int k = Integer.parseInt(line.split(" ")[1]);   // k 번째를 제거
    
            List<Integer> result = getResult(n, k);
    
            sb.append("<");
            for (int i = 0; i < result.size() - 1; i++) {
                sb.append(result.get(i)).append(", ");
            }
            sb.append(result.get(result.size()-1)).append(">");
    
            System.out.println(sb);
        }
    
        private static List<Integer> getResult(int n, int k) {
    
            Queue<Integer> circle = new LinkedList<>(); // 원을 이루고 있는 사람들
            List<Integer> result = new ArrayList<>();   // 정답으로 출력할 리스트 - 요세푸스 순열
    
            // 원에 사람들을 넣음
            for (int i = 1; i <= n; i++) {
                circle.add(i);
            }
    
            // 원에 있는 사람이 모두 제거될 때까지 반복
            while (!circle.isEmpty()) {
                for (int i = 0; i < k - 1; i++) {
                    int pick = circle.poll();
                    circle.offer(pick);    // (k - 1) 번째 사람까지 앞에서 꺼내고 뒤로 넣는 작업 반복
                }
                // k번째 사람을 뽑아서 요세푸스 순열 정답 리스트에 넣음
                result.add(circle.poll());
            }
            return result;
        }
    }
