package sk000801.백준.복습;
import java.io.*;

public class 주유소 {
    static int n;
    static long[] len;
    static long[] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        len = new long[n];
        price = new long[n+1];
        long answer = 0;

        String[] s = br.readLine().split(" ");
        for(int i = 1; i < n; i++) {
            len[i] = Long.parseLong(s[i-1]);
        }

        s = br.readLine().split(" ");
        for(int i = 1; i <= n; i++) {
            price[i] = Long.parseLong(s[i-1]);
        }

        long temp = price[1];
        for(int i = 1; i < n; i++) {
            if(temp > price[i]) temp = price[i];
            answer += temp*len[i];
        }

        System.out.println(answer);
    }
}
