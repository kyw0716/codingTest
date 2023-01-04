package sk000801.백준.DP;
import java.io.*;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];
        int[] dp = new int[n+1];

        String[] s = br.readLine().split(" ");
        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(s[i-1]);
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(num[j] < num[i] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}

//찾아보니 나는 bottom-up 방식으로 푼 듯,,