package sk000801.백준.DP;
import java.util.*;
//https://www.acmicpc.net/problem/1699

public class 제곱수의합 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        if(n==1) {System.out.println(1);return;}
        dp[2]= 2;
        if(n==2) {System.out.println(2);return;}

        for(int i = 3; i <= n; i++) {
            dp[i] = i;
            for(int j = 1; j*j <= i; j++) {
                if(dp[i] > dp[i-j*j]+1) dp[i] = dp[i-j*j]+1;
                //제곱수를 빼고 남은 숫자의 최소값을 더해줌
            }
        }

        System.out.println(dp[n]);
    }
}
