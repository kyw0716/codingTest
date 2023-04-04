package sk000801.백준.복습;
import java.util.*;

//2트라서 15분... 
public class 파일합치기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tc = in.nextInt();
        for(int i = 0; i < tc; i++) {
            int n = in.nextInt();
            int[] num = new int[n];
            int[] sum = new int[n];
            int[][] dp = new int[n][n];
            for(int j = 0; j < n; j++) {
                num[j] = in.nextInt();
                if(j==0) sum[0] = num[0];
                else sum[j] = sum[j-1]+num[j];
            }

            for(int j = 0; j < n-1; j++) {
                dp[j][j+1] = num[j]+num[j+1];
            }

            for(int x = 1; x < n; x++) { //dp[i][j] = i장부터 j장까지의 파일 합치는데 최솟값
                for(int y = 0; y+x < n; y++) {
                    for(int z = y; z < y+x; z++) {
                        if(dp[y][x+y] == 0) {
                            if(y<1) dp[y][x+y] = dp[y][z]+dp[z+1][x+y]+sum[x+y];
                            else dp[y][x+y] = dp[y][z]+dp[z+1][x+y]+sum[x+y]-sum[y-1];
                        } else {
                            if(y==0) dp[y][x+y] = Math.min(dp[y][x+y], dp[y][z]+dp[z+1][y+x]+sum[x+y]);
                            else dp[y][x+y] = Math.min(dp[y][x+y], dp[y][z]+dp[z+1][y+x]+sum[x+y]-sum[y-1]);
                        }
                    }
                }
            }

            System.out.println(dp[0][n-1]);
        }
    }
}
