package sk000801.백준.DP;
import java.io.*;

public class 내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[][] num = new int[n][3];
        int[][] dp = new int[n][3];
        int[][] dpm = new int[n][3];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i = 0; i < 3; i++) {
            dp[0][i] = num[0][i];
            dpm[0][i] = num[0][i];
        }

        for(int i = 1; i < n; i++) {
            dp[i][0] = num[i][0]+Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = num[i][1]+Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
            dp[i][2] = num[i][2]+Math.max(dp[i-1][1], dp[i-1][2]);

            dpm[i][0] = num[i][0]+Math.min(dpm[i-1][0], dpm[i-1][1]);
            dpm[i][1] = num[i][1]+Math.min(Math.min(dpm[i-1][0], dpm[i-1][1]), dpm[i-1][2]);
            dpm[i][2] = num[i][2]+Math.min(dpm[i-1][1], dpm[i-1][2]);
        }

        int max = Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        int min = Math.min(Math.min(dpm[n-1][0], dpm[n-1][1]), dpm[n-1][2]);

        System.out.println(max+" "+min);
    }
}
