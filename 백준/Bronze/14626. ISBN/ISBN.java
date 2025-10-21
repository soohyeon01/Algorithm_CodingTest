import java.io.*;
import java.util.*;

public class Main {
    /**
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String isbn = br.readLine();
        int[] arr = new int[12];
        int m = isbn.charAt(12) - '0';
        int index = 0;

        // 각 자리가 숫자인 경우 배열에 저장 , * 인 경우 -1로 치환해서 저장 후 인덱스 따로 저장
        for (int i = 0; i < arr.length; i++) {
            char temp = isbn.charAt(i);
            if (temp == '*') {
                index = i;
                arr[i] = -1;
            } else {
                arr[i] = temp - '0';
            }
        }

        // *을 제외한 합 구하기
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) continue;
            if (i % 2 == 0) sum += arr[i];
            else sum += arr[i] * 3;
        }

        // 나머지가 0이 되는 값 * 찾기
        for (int i = 0; i <= 9; i++) {
            // *까지 포함한 최종 값을 담는 변수
            int finalSum = sum;
            if (index % 2 == 0) {
                finalSum += i;
            } else {
                finalSum += (i * 3);
            }

            // 10 - finalSum % 10 -> 원래의 m을 구하는 방법
            // (10 - finalSum % 10) % 10 -> 10으로 한 번 더 나누어 m이 10이 나오는 경우 방지
            int check = (10 - finalSum % 10) % 10;

            // 임의의 숫자를 넣어서 계산한 check 값이 m과 같다면 그 값이 정답
            if (check == m) {
                System.out.println(i);
                return;
            }
        }
    }
}
