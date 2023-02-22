package sk000801.백준.복습;
import java.io.*;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j <= i; j++) {
                if(num[i]>num[j]) dp[i] = Math.max(dp[i], 1+dp[j]);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
