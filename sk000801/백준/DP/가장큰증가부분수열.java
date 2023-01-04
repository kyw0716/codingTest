package sk000801.백준.DP;
import java.io.*;

public class 가장큰증가부분수열 {
    static int[] num;
    static int[] dp;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n+1];
        dp = new int[n+1];
        answer = 0;

        String[] s = br.readLine().split(" ");
        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(s[i-1]);
        }

        dp[1] = num[1];
        answer = dp[1];
        for(int i = 2; i <= n; i++) {
            dp[i] = num[i];
            for(int j = 1; j < i; j++) {
                if(num[i]>num[j]) { //현재 값이 이전값보다 크면(증가수열이라면?)
                    dp[i] = Math.max(dp[i], dp[j]+num[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
