package sk000801.백준.DP;
import java.util.*;

public class _2n타일링2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] dp = new int[n+1];

        if(n==1) {System.out.println(1);return;}
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2]*2%10007+dp[i-1]%10007)%10007;
        }

        System.out.println(dp[n]);
    }
}

// 값 1 -> 1
// 값 2 -> 3
// 값 3 -> 2+3
// 값 4 -> 6+5
// 값 5 -> 10+11
// 값 6 -> 22+21
// 값 7 -> 42+43
// 값 8 -> 86+85
//1. 크기가 i-1인 직사각형을 채우는 방법의 +1이다,(세로로 긴 사각형1개만 가능함)
//2. 크기가 i-2인 직사각혀을 채우는 방법의 *2이다.(가로로 긴 사각형 2개와, 정사각형 1개가 가능함)