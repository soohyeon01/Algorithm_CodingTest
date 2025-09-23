import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int resultInt = calcInt(a, b, c);
        int resultString = calcString(a, b, c);

        bw.write(String.valueOf(resultInt));
        bw.newLine();
        bw.write(String.valueOf(resultString));


        bw.flush();
        bw.close();
        br.close();
    }

    private static int calcString(String a, String b, String c) {
        String ab = a + b;
        int i = Integer.parseInt(ab);
        int k = Integer.parseInt(c);

        return i - k;
    }

    private static int calcInt(String a, String b, String c) {
        int i = Integer.parseInt(a);
        int j = Integer.parseInt(b);
        int k = Integer.parseInt(c);

        return i + j - k;
    }

}