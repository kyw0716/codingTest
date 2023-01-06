package sk000801.백준.DP;
import java.io.*;
import java.util.StringTokenizer;

public class 스티커 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sti = new int[2][n];
            int[][] dp = new int[2][n+1];
            for(int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int r = 0; r < n; r++) {
                    sti[j][r] = Integer.parseInt(st.nextToken());
                }
            }

            // if(n==1) {System.out.println(Math.max(sti[0][0], sti[1][0]));continue;}
            dp[0][1] = sti[0][0];
            dp[1][1] = sti[1][0];

            for(int p = 2; p <= n; p++) {
                dp[0][p] += Math.max(dp[1][p-1], dp[1][p-2])+sti[0][p-1];
                dp[1][p] += Math.max(dp[0][p-1], dp[0][p-2])+sti[1][p-1];
            }

            sb.append(String.valueOf(Math.max(dp[0][n], dp[1][n])));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
