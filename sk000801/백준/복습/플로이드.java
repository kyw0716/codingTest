package sk000801.백준.복습;
import java.io.*;

public class 플로이드 {
    static int n;
    static int[][] bus;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        bus = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i!=j) bus[i][j] = 100_000;
            }
        }

        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            bus[a][b] = Math.min(bus[a][b], c);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= n; r++) {
                    if(i==j||j==r||i==r) continue;
                    if(bus[j][r] > bus[j][i]+bus[i][r]) {
                        bus[j][r] = bus[j][i]+bus[i][r];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(bus[i][j] == 100_000) bus[i][j] = 0;
                System.out.print(bus[i][j]+" ");
            }
            System.out.println();
        }
    }
}
