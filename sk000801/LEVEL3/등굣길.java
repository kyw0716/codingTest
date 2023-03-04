package sk000801.LEVEL3;

//점화식은 금방 구했지만 예외 경우가 많아 힘들었던 문제스
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        for(int i = 2; i <= n; i++) {
            if(dp[i][1] == -1 || dp[i-1][1] == -1) dp[i][1] = -1; //특히 여기!!
            else dp[i][1] = 1;
        }
        for(int i = 2; i <= m; i++) {
            if(dp[1][i] == -1 || dp[1][i-1] == -1) dp[1][i] = -1;
            else dp[1][i] = 1;
        }
        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= m; j++) {
                if(dp[i][j] == -1) continue;
                else if(dp[i-1][j] == -1) dp[i][j] = dp[i][j-1]%1_000_000_007;
                else if(dp[i][j-1] == -1) dp[i][j] = dp[i-1][j]%1_000_000_007;
                else dp[i][j] = dp[i-1][j]%1_000_000_007+dp[i][j-1]%1_000_000_007;
            }
        }

        return dp[n][m] == -1 ? 0 : dp[n][m]%1_000_000_007;
    }
}
