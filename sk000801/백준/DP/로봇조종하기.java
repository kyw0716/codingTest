package sk000801.백준.DP;
import java.util.*;

//문제 혼자 잘못 읽고 완전 DP로 풀다가 fail
//bfs로 풀어보려다가 아닌 거 같아서 fail
//결국 풀이 보고 풀어버림...
//https://blog.naver.com/occidere/220808155184t 선생님 풀이 참조
//https://www.acmicpc.net/problem/2169

public class 로봇조종하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] val = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        int[][] temp = new int[2][m+2];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                val[i][j] = in.nextInt();
            }
        }

        dp[1][1] = val[1][1];
        for(int j = 2; j <= m; j++) {
            dp[1][j] += val[1][j]+dp[1][j-1];
        }

        for(int i = 2; i <= n; i++) {
            temp[0][0] = dp[i-1][1]; //temp[0]이 오른쪽으로
            for(int j = 1; j <= m; j++) { //오른쪽으로 흐름이 이동하는 경우
                //좌->우, 위->아래 중 큰 값을 비교
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j])+val[i][j];
            }
            temp[1][m+1] = dp[i-1][m]; //temp[1]이 왼쪽으로
            for(int j = m; j >= 1; j--) { //왼쪽으로 흐름이 이동하는 경우
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j])+val[i][j];
            }
            for(int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
       System.out.println(dp[n][m]);
    }
}
