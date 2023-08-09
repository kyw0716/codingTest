package sk000801.LEVEL3;
import java.util.*;

//32분 but 힌트 참조
public class 거스름돈 {
    public static int solution(int n, int[] money) {
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
        
       for(int i = 0; i <= n; i++) {
        System.out.print(dp[i]+" ");
       }

        return (int)dp[n]%1_000_000_007;
    }

    public static void main(String[] args) {
        int[] money = {1,2,5};
        System.out.println(solution(8, money));
    }
}

