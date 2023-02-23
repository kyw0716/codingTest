package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 동전1 {
    static int n, k;
    static int[] num;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        num = new int[n];
        dp = new int[k+1];
        dp[0] = 1;

        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                if(num[i] <= j) dp[j] += dp[j-num[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
