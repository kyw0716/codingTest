package sk000801.백준.복습;
import java.io.*;

public class 연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];

        if(n==1) {System.out.println(br.readLine()); return;}

        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }

        dp[0] = num[0];
        int max = num[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+num[i], num[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
