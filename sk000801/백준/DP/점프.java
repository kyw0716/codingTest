package sk000801.백준.DP;
import java.util.*;

public class 점프 {
    static int n;
    static long[][] dp;
    static int[][] num;
    public static long dfs(int i, int j) {
        if(i == n-1 && j == n-1) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = 0;
        if(i+num[i][j]<n && num[i][j] != 0) dp[i][j] += dfs(i+num[i][j], j);
        if(j+num[i][j]<n && num[i][j] != 0) dp[i][j] += dfs(i, j+num[i][j]);
        return dp[i][j];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dp = new long[n][n];
        num = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                num[i][j] = in.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }
}
