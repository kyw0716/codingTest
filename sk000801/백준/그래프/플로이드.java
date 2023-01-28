package sk000801.백준.그래프;
import java.util.*;

public class 플로이드 {
    static int[][] cost;
    static int n;
    public static void floyd() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= n; r++) {
                    if(i==j || j==r || i==r) continue;
                    if(cost[j][r] > cost[j][i]+cost[i][r]) {
                        cost[j][r] = cost[j][i]+cost[i][r];
                    }
                }
            } 
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());
        int m = Integer.parseInt(in.nextLine());
        cost = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i != j) cost[i][j] = 98765432;
            }
        }

        for(int i = 0; i < m; i++) {
            String[] s = in.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            cost[a][b] = Math.min(cost[a][b], c);
        }

        floyd(); 
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(cost[i][j] == 98765432) cost[i][j] = 0;
                System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }
    }
}
