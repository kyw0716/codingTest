package sk000801.백준.DP;
import java.util.*;
//10844번 백준
//https://www.acmicpc.net/problem/10844

public class 쉬운계단수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[][] dp = new long[n+1][10];

        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1; //초기값 설정
        }

        for(int i = 2; i <= n; i++) { //두번째 자릿수부터 
            for(int j = 0; j < 10; j++) { 
                if(j==0) dp[i][0] = dp[i-1][1]%1000000000;
                else if(j==9) dp[i][9] = dp[i-1][8]%1000000000;
                else dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
                //이전자릿수의자릿값
            }
        }
        //0일때는 다음에 올 수가 1밖에 없고, 9라면 다음에 올 수는 8밖에 없음

        long result = 0;
        for(int i = 0; i <10; i++) {
            result += dp[n][i];
        }

        System.out.println(result%1000000000);
    }
}

// 1 -> 각자 1씩 -> 9
// 2 -> 17 
// 1 -> 2 , 2 -> 2, 3 -> 2, 4 -> 2, .. , 9 -> 1
// 10, 21, 32, 43, 54, 65, 76, 87, 98, 
// 12, 23, 34, 45, 56, 67, 78, 89
// 3 -> 32 
// 1 -> 3, 2 -> 4, 3 -> 4, .. , 8 -> 3, 9 -> 2
// 210, 321, 432, 543, 654, 765, 876, 987, 
// 101, 212, 323, 434, 545, 656, 767, 878, 989,
// 123, 234, 345, 456, 567, 678, 789, 
// 121, 232, 343, 454, 565, 676, 787, 898

