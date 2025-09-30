import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    /**
     * 정렬
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];

        for (int i = 0; i < points.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        // Comparator로 사용자 정의 정렬
        Arrays.sort(points, (a, b) -> {
            if (a.x == b.x) {
                return a.y - b.y;   // x좌표가 같으면 y좌표 오름차순 
            }
            return a.x - b.x;   // x좌표 오름차순
        });

        // 출력 형식에 맞춰 출력
        StringBuilder sb = new StringBuilder();
        for (Point p : points) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        System.out.println(sb);
    }

}