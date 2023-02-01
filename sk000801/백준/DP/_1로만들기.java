package sk000801.백준.DP;
import java.util.*;

public class _1로만들기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 0;
        if(n==1) {System.out.println(0); return;}

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+1; //1로 뺄때의 경우를 초기값으로
            if(i%2==0 && dp[i] > dp[i/2]+1) {
                dp[i] = dp[i/2]+1; //2로 나눠질때의 경우가 더 작다면 
            }
            if(i%3==0 && dp[i] > dp[i/3]+1) {
                dp[i] = dp[i/3]+1; //3으로 나눠질때의 경우가 더 작다면
            }
        }

        System.out.println(dp[n]);
    }
}
