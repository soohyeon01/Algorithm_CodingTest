
import java.io.*;
import java.util.*;

public class Main {

	public static int calc(int a, int b) {
		int t = 0;
		if (b - a <= a)
			t = b - a;
		else
			t = a; // 작은 수를 t로 정의

		if (t == 0)
			return 1;
		
		else {
			double nu = 1, de = 1; // 분자와 분모로 사용할 변수 선언

			for (int i = 1; i <= t; i++) {
				de *= i;
			}
			for (int i = b; i > b - t; i--) {
				nu *= i;
			}

			return (int)(nu / de);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int answer = calc(m, n);

			bw.write(String.valueOf(answer) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
