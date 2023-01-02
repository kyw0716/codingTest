package sk000801.백준.DP;
import java.io.*;

public class 피보나치수2 {
    public static void dp(int n) {
        long[] pibo = new long[n+1];

        pibo[0] = 0;
        pibo[1] = 1;

        for(int i = 2; i <= n; i++) {
            pibo[i] = pibo[i-2]+pibo[i-1];
        }

        System.out.println(pibo[n]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp(n);
    }
}