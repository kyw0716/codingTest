package sk000801.LEVEL3;

class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len][len];
        
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < len; i++) {
            for(int j = 0; j <= i; j++) {
                if(j==0) dp[i][j] = dp[i-1][j]+triangle[i][j];
                else dp[i][j] = Math.max(dp[i-1][j]+triangle[i][j], dp[i-1][j-1]+triangle[i][j]);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < len; i++) {
            answer = Math.max(dp[len-1][i], answer);
        }
        
        return answer;
    }
}
