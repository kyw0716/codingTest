package sk000801.백준.DP;
import java.util.*;

//점화식 생각,,
//dp[n][k] = dp[n][k-1]+dp[n-1][k-1]+dp[n-2][k-1]+...+dp[0][k-1]
//이거 근데 백트래킹으로 풀어도 되지 않나..?
//https://www.acmicpc.net/problem/2225
public class 합분해 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        long[][] dp = new long[n+1][k+1];

        for(int i = 0; i < 2; i++) {
            for(int j = 1; j <= k; j++) {
                if(i==0) dp[i][j] = 1;
                else dp[i][j] = j;
            }
        } 
        
        for(int i = 0; i <= n; i++) {
            dp[i][1] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= k; j++) {
                for(int r = i; r >= 0; r--) {
                    dp[i][j] += dp[r][j-1]%1_000_000_000;
                }
            }
        }

        System.out.println(dp[n][k]%1_000_000_000);
    }
}
