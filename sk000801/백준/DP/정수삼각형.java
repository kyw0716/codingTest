package sk000801.백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n+1][n+1];
        int[][] d = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 1; j <= i; j++) {
                a[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        d[1][1] = a[1][1];

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                d[i][j] = Math.max(d[i-1][j-1]+a[i][j], d[i-1][j]+a[i][j]);
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, d[n][i]);
        }

        System.out.println(max);
    }
}
