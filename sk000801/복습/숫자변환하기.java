package sk000801.복습;
import java.util.*;

//18분
//dp로 풀어야 하는 것ㅠ
public class 숫자변환하기 {
    public static int solution(int x, int y, int n) {
        if(x == y) return 0;
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[x] = 0;
        for(int i = x; i <= y; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;
            if(i+n <= y) dp[i+n] = Math.min(dp[i]+1, dp[i+n]);
            if(2*i <= y) dp[2*i] = Math.min(dp[i]+1, dp[2*i]);
            if(3*i <= y) dp[3*i] = Math.min(dp[i]+1, dp[3*i]);
        }
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
    public static void main(String[] args) {
        int x1 = 10; int y1 = 40; int n1 = 5; 
        System.out.println(solution(x1, y1, n1));
    }
}
