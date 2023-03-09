package sk000801.백준.DP;
import java.io.*;
import java.util.*;

public class 파일합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] num = new int[n];
            int[][] dp = new int[n][n];
            int[] sum = new int[n];

            String[] s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(s[j]);
                if(j>=1) sum[j] = sum[j-1]+num[j];
                else sum[j] = num[j]; 
            }

            for(int j = 0; j < n-1; j++) {
                dp[j][j+1] = num[j]+num[j+1];
            }

            //dp[i][j] = min(dp[i][k] + dp[k + 1][j] + sum(i, j) 
            for(int z = 1; z < n; z++) { //x~y까지의 파일을 합치는데 드는 최소 비용
                for(int x = 0; x+z < n; x++) {
                    for(int y = x; y < x+z; y++) {
                        if(dp[x][x+z] == 0) {
                            if(x < 1) dp[x][z+x] = dp[x][y]+dp[y+1][x+z]+sum[z+x];
                            else dp[x][z+x] = dp[x][y]+dp[y+1][x+z]+sum[z+x]-sum[x-1];
                        } else {
                            int total = x != 0 ? sum[x+z]-sum[x-1] : sum[x+z];
                            dp[x][z+x] = Math.min(dp[x][z+x], dp[x][y]+dp[y+1][z+x]+total);
                        }
                    }
                }
            }

            sb.append(dp[0][n-1]).append("\n");
        }

        System.out.println(sb);
    }
}
