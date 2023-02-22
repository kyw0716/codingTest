package sk000801.백준.복습;
import java.io.*;

public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] color = new int[n][3];

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i = 1; i < n; i++) {
            color[i][0] += Math.min(color[i-1][1], color[i-1][2]);
            color[i][1] += Math.min(color[i-1][0], color[i-1][2]);
            color[i][2] += Math.min(color[i-1][0], color[i-1][1]);
        }
        
        System.out.println(Math.min(Math.min(color[n-1][0], color[n-1][1]), color[n-1][2]));
    }
}
