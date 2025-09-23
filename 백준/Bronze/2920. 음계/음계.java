import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        StringTokenizer st = new StringTokenizer(br.readLine());
        String ascending = "1 2 3 4 5 6 7 8";
        String descending = "8 7 6 5 4 3 2 1";
        String input = br.readLine();

        if (input.equals(ascending)) {
            bw.write("ascending");
        } else if (input.equals(descending)) {
            bw.write("descending");
        } else {
            bw.write("mixed");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}