package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

public class 노드사이의거리 {
    static int n;
    static int[][] dist;
    static StringBuffer sb = new StringBuffer("");
    public static void floyd() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= n; r++) {
                    if(i==j||j==r||i==r) continue;
                    if(dist[j][r] > dist[j][i]+dist[i][r]) {
                        dist[j][r] = dist[j][i]+dist[i][r];
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        dist = new int[n+1][n+1];
        int m = Integer.parseInt(s[1]);

        for(int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 1_000_000);
        }
        

        for(int i = 0; i < n-1; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            dist[a][b] = dist[b][a] = c;
        }

        floyd();

        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if(a==b) {sb.append("0\n"); continue;}
            sb.append(dist[a][b]).append("\n");
        }

        System.out.println(sb);
    }
}
