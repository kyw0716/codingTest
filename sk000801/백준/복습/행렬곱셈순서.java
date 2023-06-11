package sk000801.백준.복습;
import java.util.*;

public class 행렬곱셈순서 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] hang = new int[n][2];
        int[][] dp = new int[n][n]; //i~j까지의 최솟값?

        for(int i = 0; i < n; i++) {
            hang[i][0] = in.nextInt();
            hang[i][1] = in.nextInt();
        }

        for(int i = 0; i < n; i++) {
            for(int j= 0; j < n; j++) {
                if(i != j) dp[i][j] = Integer.MAX_VALUE;
            }
        }

        //어차피 결론 행렬의 크기는 (첫값*마지막값)임
        for(int i = 1; i < n; i++) { //최솟값 갖는 행렬 개수?? (ex. 1이면 j부터 j+1까지)
            for(int j  = 0; j+i < n; j++) { //시작값
                for(int r = j; r < j+i; r++) { //구간 범위를 나누는 기준점, 이 기준으로 곱하기 진행
                    int val = dp[j][r]+dp[r+1][j+i]+hang[j][0]*hang[r][1]*hang[j+i][1];
                    dp[j][j+i] = Math.min(val, dp[j][j+i]);
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}
