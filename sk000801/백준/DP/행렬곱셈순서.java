package sk000801.백준.DP;
import java.util.*;

//A~x, x~B까지 곱하는 연산 더하기
//A~x연산+x~B연산+A*x*B;
public class 행렬곱셈순서 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] size = new int[n][2];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            size[i][0] = in.nextInt();
            size[i][1] = in.nextInt();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j) dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j= 0; j+i < n; j++) {
                // j, j+i 
                for(int r = j; r < j+i; r++) {
                    int val = dp[j][r]+dp[r+1][j+i]+size[j][0]*size[r][1]*size[j+i][1];
                    dp[j][j+i] = Math.min(val, dp[j][j+i]);
                }
            }
        }

        //0~n-1까지의 행렬곱
        System.out.println(dp[0][n-1]);
    }
}
