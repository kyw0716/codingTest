package sk000801.백준.DP;
import java.util.*;

public class 동물원 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] dp = new long[n+1];
        dp[1] = 3;
        if(n==1) {System.out.println(dp[1]); return;}
        dp[2] = 7;
        if(n==2) {System.out.println(dp[2]); return;}

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-2]%9901+(2*dp[i-1])%9901;
            dp[i] %= 9901;
        }

        System.out.println(dp[n]);
    }
}
