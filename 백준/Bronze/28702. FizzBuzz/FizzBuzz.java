import java.io.*;
import java.util.*;

public class Main {
    /**
     *  '0' -> 48
     *  'A' -> 65
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        String[] arr = new String[3]; // 각 줄을 저장할 문자열 배열
        arr[0] = br.readLine();
        arr[1] = br.readLine();
        arr[2] = br.readLine();


        for (int i = 0; i < arr.length; i++) {
            // 숫자 유무 확인 로직
            if (arr[i].charAt(0) < 65) {    // 입력받은 각 문자열이 숫자라면?
                int ans = Integer.parseInt(arr[i]) + (3 - i);
                System.out.println(changeLogic(ans));
                return;
            }
        }

        // 숫자가 있다면 인덱스 값으로 직접 숫자를 구함

//        System.out.println(sb);
    }

    private static String changeLogic(int ans) {
        String result = "";
        if (ans % 3 == 0 && ans % 5 == 0) {
            result = "FizzBuzz";
        } else if (ans % 3 != 0 && ans % 5 == 0) {
            result = "Buzz";
        } else if (ans % 3 == 0 && ans % 5 != 0) {
            result = "Fizz";
        } else result = String.valueOf(ans);
        
        return result;
    }
}
