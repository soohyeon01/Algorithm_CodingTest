import java.io.*;
import java.util.Arrays;

public class Main {
    /**
     * 정렬
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());  // 입력받을 숫자의 개수
        int[] arr = new int[cnt];   // 입력받은 수 만큼 배열 생성

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }   // 입력 받은 수를 배열에 하나씩 넣음

        Arrays.sort(arr);   // 오름차순 정렬

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }   // 정렬된 수를 출력

        bw.flush();
        bw.close();
        br.close();
    }

}
