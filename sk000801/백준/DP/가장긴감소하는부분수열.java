package sk000801.백준.DP;
import java.util.*;
//https://www.acmicpc.net/problem/11722
public class 가장긴감소하는부분수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n+1];
        int[] dp = new int[n+1];
        //dp는 그 인덱스의 값을 포함하는 가장 긴 감소 부분수열!
        
        for(int i = 1; i <= n; i++) {
            num[i] = in.nextInt();
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
            //무조건 그 인덱스의 값을 포함해야 하므로 1로 초기값 설정
            for(int j = 1; j <= i; j++) {
                //이전 인덱스가 이후 인덱스의 값보다 크고 dp배열 값도 이전 인덱스의 값이 더 크다면
                if(dp[i] < dp[j]+1 && num[i] < num[j]) {
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
