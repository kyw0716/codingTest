package sk000801.백준.복습;
import java.util.*;

//다시 정리!! 우선순위 큐로 푸는 간단한 문제인 줄 알았다
public class 파일합치기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer("");

        int tc = in.nextInt();
        for(int i = 0; i < tc; i++) {
            int n = in.nextInt();
            int[] num = new int[n];
            int[] sum = new int[n];
            int[][] dp = new int[n][n]; //i~j 페이지까지의 최솟값

            for(int j = 0; j < n; j++) {
                num[j] = in.nextInt();
            }

            sum[0] = num[0];
            for(int j = 1; j < n; j++) {
                sum[j] = sum[j-1]+num[j];
            }

            for(int j = 0; j < n-1; j++) {
                dp[j][j+1] = num[j]+num[j+1];
            }

            for(int x = 1; x < n; x++) { //y~y+x까지의 숫자합 구하기(살짝 플로이드 같기도)
                for(int y = 0; y+x < n; y++) {
                    for(int z = y; z < x+y; z++) {
                        if(dp[y][y+x] == 0) { 
                            if(y < 1) dp[y][y+x] = dp[y][z]+dp[z+1][y+x]+sum[x+y];
                            else dp[y][y+x] = dp[y][z]+dp[z+1][y+x]+sum[y+x]-sum[y-1];
                        } else {
                            int total = y != 0 ? sum[y+x]-sum[y-1] : sum[x+y];
                            dp[y][y+x] = Math.min(dp[y][x+y], dp[y][z]+dp[z+1][y+x]+total);
                        }
                    }
                }
            }
            sb.append(dp[0][n-1]).append("\n");
        }
        System.out.println(sb);
    }
}
