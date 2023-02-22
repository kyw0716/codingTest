package sk000801.백준.복습;
import java.io.*;

public class 평범한배낭 {
    static int n, k;
    static int[][] dp;
    static int[][] bag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        dp = new int[n+1][k+1]; // 인덱스가 무게 가지는 값이 가치
        bag = new int[n+1][2]; //무게와 가치

        for(int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            bag[i][0] = Integer.parseInt(s[0]);
            bag[i][1] = Integer.parseInt(s[1]);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                if(bag[i][0] <= j) {
                    if(bag[i][1] + dp[i-1][j-bag[i][0]] > dp[i-1][j]) {
                        dp[i][j] = bag[i][1]+dp[i-1][j-bag[i][0]];
                    }
                    else dp[i][j] = dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}
