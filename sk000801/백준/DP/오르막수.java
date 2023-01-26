package sk000801.백준.DP;
import java.util.*;

//오르막수라 0은 9개가 모두 가능하고, 9는 아무것도 넣을 수 없음 ㅠ
public class 오르막수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[][] dp = new long[n+1][10];
        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) { // i번째 자리수
            for(int j = 0; j <= 9; j++) { //들어갈수있는 숫자
                for(int p = j; p <= 9; p++) {
                    dp[i][j] += dp[i-1][p];
                }
                dp[i][j] %= 10007;
            }
        }

        long result = 0;
        for(int i = 0; i <= 9; i++) {
            result += dp[n][i];
        }

        System.out.println(result%10007);
    }
}

// n = 1 -> 0~9
// n = 2 -> 0: 1~9 / 1: 2~9 / 2: 3~9
      
