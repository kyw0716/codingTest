package sk000801.백준.DP;
import java.io.*;
import java.util.*;

//점화식 너란 녀석 너무 어려운것,,
//https://www.acmicpc.net/problem/2294
public class 동전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        int[] dp = new int[k+1];
        Arrays.fill(dp, 98765432);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++) {
            for(int j = num[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j-num[i]]+1);
            }
        }

        System.out.println(dp[k] == 98765432 ? -1 : dp[k]);
    }
}
