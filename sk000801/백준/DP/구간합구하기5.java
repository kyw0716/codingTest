package sk000801.백준.DP;
import java.util.*;

public class 구간합구하기5 {
    //한줄씩 인덱스가 넘겨질 때마다 누적되면 좋겠다
    //근데 그게 의미가 있을까?
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer("");

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] num = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                num[i][j] = in.nextInt();
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= j; r++) {
                    dp[i][j] += num[i][r];
                }
            }
        }

        for(int i = 0; i < m; i++) {
            int x1 = in.nextInt(); //1
            int y1 = in.nextInt(); //2
            int x2 = in.nextInt(); //1
            int y2 = in.nextInt(); //2

            int ans = 0;
            if(x1==x2) {
                ans += dp[x1][y2]-dp[x1][y1-1];
                sb.append(ans+"\n");
                continue;
            } 
                
            if(x1==x2 && y1==y2) {
                ans = dp[x1][y1];
                sb.append(ans+"\n");
                continue;
            }

            for(int j = x1; j <= x2; j++) {
                ans += dp[j][y2]-dp[j][y1-1];
            }

            sb.append(ans+"\n");
        }

        System.out.println(sb);
    }
}
