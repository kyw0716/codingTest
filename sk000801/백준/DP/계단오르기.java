package sk000801.백준.DP;
import java.io.*;

public class 계단오르기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n==1) {
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }

        int[] stair = new int[n+1];
        int[] dp = new int[n+1]; //최댓값을 저장하는 dp

        for(int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = stair[1];
        dp[2] = stair[1]+stair[2];

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]+stair[i-1])+stair[i];
        }

        System.out.println(dp[n]);
    }
}
