package sk000801.백준.DP;
import java.io.*;

//https://www.acmicpc.net/problem/11048
//처음엔 왜 dp인가 했는데 납득해버린 문제

public class 이동하기 {
    static int n, m;
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    static int[][] miro;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        miro = new int[1001][1001];
        dp = new int[1001][1001];

        for(int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            for(int j = 1; j <= m; j++) {
                miro[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = miro[i][j]+Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
            }
        }

        System.out.println(dp[n][m]);
    }
}
