package sk000801.백준.DP;
import java.io.*;

public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] price = new int[n+1][3+1];

        for(int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 1; j <= 3; j++) {
                price[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        for(int i = 2; i <= n; i++) {
            price[i][1] += Math.min(price[i-1][2], price[i-1][3]);
            price[i][2] += Math.min(price[i-1][1], price[i-1][3]);
            price[i][3] += Math.min(price[i-1][1], price[i-1][2]);
        }
        
        System.out.println(Math.min(Math.min(price[n][1], price[n][2]),price[n][3]));
    }
}
