import java.io.*;
import java.util.*;

/**
 * 2805 - 나무 자르기, 이분탐색
 * 절단기의 높이가 정해져 있는 상태에서 적어도 M미터 가져가야함
 * 절단기의 높이 H는 최대: 가장 높은 나무, 최소: 0
 * 중간값부터 시작하여 범위를 좁혀나가는 방식이 적합하므로 최대값을 찾는 과정이 한번 필요할 것으로 예상
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 최소 가져가고 싶은 나무의 길이

        // 트리배열 생성
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        
        getAnswer(trees, M);
    }

    private static void getAnswer(int[] trees, int M) {

        // 절단기의 범위 설정, 나무수와 나무길이의 범위를 고려하여 long으로 설정
        long min = 0;
        // 나무 최대값을 찾는 메서드
        long max = search_max(trees);
        long ans = 0;

        while (min <= max) {
            long sum = 0;
            long mid = (min + max) / 2;
            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }
            if (sum >= M) { // 절단기의 높이가 적절할 수도, 낮을 수도 있기 때문에 ans에 현재 절단기 값을 넣어두고 다시 계산해 봄
                ans = mid;
                min = mid + 1;
            } else { // sum < M : 절단기의 높이가 너무 높음
                max = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static int search_max(int[] trees) {
        int max = Integer.MIN_VALUE;
        for (int tree : trees) {
            if (tree > max) {
                max = tree;
            }
        }
        return max;
    }
}
