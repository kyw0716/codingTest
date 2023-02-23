package sk000801.백준.복습;
import java.util.*;

public class 오르막수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[][] dp = new long[n+1][10];

        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
            dp[2][i] = 10-i;
        }

        for(int i = 3; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int p = j; p <= 9; p++) {
                    dp[i][j] += dp[i-1][p];
                }
                dp[i][j] %= 10_007;
            }
        }

        long res = 0;
        for(int i = 0; i <= 9; i++) {
            res += dp[n][i];
        }

        System.out.println(res%10_007);
    }
}
