package sk000801.LEVEL3;
import java.util.*;

//32분 but 힌트 참조
class Solution {
    public int solution(int n, int[] money) {
        Arrays.sort(money);
        long[] dp = new long[n+1];
        
        for(int i = 0; i <= n; i++) {
            if(i%money[0] == 0) dp[i] = 1;
        }
        
        for(int i = 1; i < money.length; i++) {
            for(int j = money[i]; j <= n; j++) {
                dp[j] += dp[j-money[i]];
            }
        }
        
       //System.out.println(dp[0]+" "+dp[1]+" "+dp[2]+" "+dp[3]+" "+dp[4]+" "+dp[5]);

        return (int)dp[n]%1_000_000_007;
    }
}
