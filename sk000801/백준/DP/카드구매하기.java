package sk000801.백준.DP;
import java.util.*;

public class 카드구매하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] price = new int[n+1];
        for(int i = 1; i <= n; i++) {
            price[i] = in.nextInt();
        }

        int[] dp = new int[n+1];
        dp[1] = price[1];
        if(n==1) {System.out.println(dp[1]); return;}
        dp[2] = Math.max(dp[1]*2, price[2]);
        if(n==2) {System.out.println(dp[2]); return;}

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i-j]+price[j], dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}

//문제에 압도당하지 말고 dp의 점화식을 어떻게 세울지 찬찬히 생각해보자.
//점화식 dp[i] = Math.max(dp[i-j]+price[j], dp[i]);
//카드 개수를 맞추기 위해 i-j를...