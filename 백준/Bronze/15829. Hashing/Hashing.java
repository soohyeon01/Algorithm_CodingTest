import java.io.*;
import java.util.*;

public class Main {
    /**
     * 해시함수 구현
     * 'a' - 96 = 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        final int r = 31;
        final int m = 1234567891;

        int l = Integer.parseInt(br.readLine());    // 입력받을 문자열의 길이 
        int[] intArr = new int[l];  // 각 자리수 숫자를 저장할 배열      

        String hash = br.readLine();
        char[] temp = hash.toCharArray();   // 입력받은 문자열을 char 배열로 우선 치환       

        for (int i = 0; i < l; i++) {
            intArr[i] = temp[i] - 96;   // char 배열에 각 문자를 int 배열에 숫자로 저장

            for (int j = 0; j < i; j++) {
                intArr[i] *= r; // 항 번호에 해당하는 r 거듭제곱
            }
        }

        int sum = 0;
        for (int i : intArr) {
            sum += i;
        }

//        System.out.println(Arrays.toString(intArr));
        System.out.println(sum);

//        System.out.println(sb);
    }
}
