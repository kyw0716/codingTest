package sk000801.백준.DP;
import java.util.*;

public class 신나는함수실행 {
    static int[][][] dp = new int[21][21][21];
    public static int w(int a, int b, int c) {
        if(a<=0 || b<=0 || c<=0) return 1;
        else if(a>20 || b>20 || c>20) {a = 20; b=20; c =20;}
        for(int i = 0; i <= a; i++) {
            for(int j = 0; j <= b; j++) {
                for(int r = 0; r <= c; r++) {
                    if(i==0 || j==0 || r==0) dp[i][j][r] = 1;
                    else if(i<j && j<r) dp[i][j][r] = dp[i][j][r-1]+dp[i][j-1][r-1]-dp[i][j-1][r];
                    else dp[i][j][r] = dp[i-1][j][r]+dp[i-1][j-1][r]+dp[i-1][j][r-1]-dp[i-1][j-1][r-1];
                }
            }
        }
        return dp[a][b][c];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer("");

        while(true) {
            StringTokenizer st = new StringTokenizer(in.nextLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1 && c==-1) break;

            sb.append("w("+a+", "+b+", "+c+") = "+w(a, b, c)+"\n");
        }

        System.out.println(sb);
    }
}
