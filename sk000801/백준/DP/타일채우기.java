package sk000801.백준.DP;
import java.util.*;

//dp[n] = dp[n-2]*3+dp[n-i]*2의 합+2*3+2
//점화식 is 문제
public class 타일채우기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] dp = new long[n+1];
        if(n>=2) dp[2] = 3;

        for(int i = 4; i <= n; i++) {
            if(i%2==0) {
                dp[i] = dp[i-2]*dp[2];
                for(int j = 4; j <= i; j++) {
                    dp[i] += dp[i-j]*2;
                }
                dp[i] += 2;
            }
        }

        System.out.println(dp[n]);
    }
}
