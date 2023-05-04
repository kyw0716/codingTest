package sk000801.복습;
import java.util.*;

//4분컷
//dp를 알고 푸니 끝!
public class 숫자변환하기2 {
    public static int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        Arrays.fill(dp, 100000);
        dp[x] = 0;
        for(int i = x; i < y; i++) {
            if(i+n <= y) dp[i+n] = Math.min(dp[i]+1, dp[i+n]);
            if(i*2 <= y) dp[i*2] = Math.min(dp[i]+1, dp[i*2]);
            if(i*3 <= y) dp[i*3] = Math.min(dp[i]+1, dp[i*3]);
        }

        return dp[y] == 100000 ? -1 : dp[y];
    }
    public static void main(String[] args) {
        int x1 = 10; int y1 = 40; int n1 = 30;
        System.out.println(solution(x1, y1, n1));
    }
}
