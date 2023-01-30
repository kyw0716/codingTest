package sk000801.백준.DP;
import java.util.*;

public class 동전1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] num = new int[n+1];
        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            num[i] = in.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                if(num[i]<=j) dp[j] += dp[j-num[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
