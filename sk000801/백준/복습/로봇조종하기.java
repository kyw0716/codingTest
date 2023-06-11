package sk000801.백준.복습;
import java.util.*;

//14분
public class 로봇조종하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] val = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                val[i][j] = in.nextInt();
            }
        }

        dp[1][1] = val[1][1];
        for(int i = 2; i <= m; i++) {
            dp[1][i] = dp[1][i-1]+val[1][i];
        }

        int[][] temp = new int[2][m+2];
        // 위, 왼쪽으로부터, 오른쪽으로부터 오는 값들을 비교해줌
        for(int i = 2; i <= n; i++) {
            temp[0][0] = dp[i-1][1];
            for(int j = 1; j <= m; j++) { //오른쪽으로 흐름 이동
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j])+val[i][j];
            }
            temp[1][m+1] = dp[i-1][m]; //위에서 내려온 값
            for(int j = m; j >= 1; j--) { //왼쪽으로 흐름 이동
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j])+val[i][j];
            }
            for(int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[n][m]);
    }
}
