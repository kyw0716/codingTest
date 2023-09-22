package sk000801.백준.DP;
import java.util.*;

public class 동전 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for(int j = 0; j < t; j++) {
            int n = in.nextInt();

            int[] num = new int[n];
            for(int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }

            int dest = in.nextInt();
            int[] dp = new int[dest+1];
            dp[0] = 1;

            for(int r = 0; r < n; r++) {
                for(int p = num[r]; p <= dest; p++) {
                    //인덱스: 현재 위치-찾는 동전 값
                    dp[p] += dp[p-num[r]];
                }
            }

            System.out.println(dp[dest]);
        }
    }   
}
