package sk000801.백준.DP;
import java.io.*;
import java.util.*;

public class 팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[][] dp = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                dp[i][j] = -1;
                for(int r = 0; r <= (j-i)/2; r++) {
                    if(num[i+r] != num[j-r]) dp[i][j] = 0;
                }
                if(dp[i][j] != 0) dp[i][j] = 1;
            }
        }

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[a-1][b-1]).append("\n");
        }

        System.out.println(sb);
    }
}
