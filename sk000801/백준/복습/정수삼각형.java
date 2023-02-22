package sk000801.백준.복습;
import java.io.*;

public class 정수삼각형 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] tri = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 1; j <= i; j++) {
                tri[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+tri[i][j];
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);
    }
}
