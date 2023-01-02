package sk000801.백준.DP;
import java.io.*;

public class 부녀회장이_될테야 {

    public static void dp(int n, int k) {
        int[][] apt = new int[k+1][n+1];

        for(int i = 1; i <= n; i++) {
            apt[0][i] += i;
        }

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= j; r++) {
                    apt[i][j] += apt[i-1][r];
                }
            }
        }

        System.out.println(apt[k][n]);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            dp(n, k);
        }
    }
}
