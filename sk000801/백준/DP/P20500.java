package sk000801.백준.DP;
import java.util.*;

public class P20500 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        if(n == 1) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[3][n+1];
        dp[0][2] = dp[1][2] = 1;

        // 15의 배수는 각 자리 수 합이 3의 배수이고, 일의 자리 0 or 5
        // 자릿수 j인 수의 각자리 합 3으로 나눈 나머지 i
        for(int i = 3; i <= n; i++) {
            dp[0][i] = (dp[1][i-1]+dp[2][i-1])%1_000_000_007;
            dp[1][i] = (dp[0][i-1]+dp[2][i-1])%1_000_000_007;
            dp[2][i] = (dp[0][i-1]+dp[1][i-1])%1_000_000_007;
        }

        System.out.println(dp[0][n]);
    }
}
