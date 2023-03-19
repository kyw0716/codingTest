package sk000801.LEVEL2;
//2xn 
//1: 1, 2: 2, 3: 3, 4: 5
//전에 백준에서도 풀었던 문제
class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2]+dp[i-1])%1_000_000_007;
        }
        return dp[n]%1_000_000_007;
    }
}
