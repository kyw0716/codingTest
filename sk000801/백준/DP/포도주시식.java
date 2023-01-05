package sk000801.백준.DP;
import java.io.*;

public class 포도주시식  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] podo = new int[n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            podo[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = podo[1];
        if(n==1) {System.out.println(dp[1]); return;}
        dp[2] = podo[1]+podo[2];
        if(n==2) {System.out.println(dp[2]); return;}

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i-3]+podo[i-1]+podo[i], dp[i-2]+podo[i]), dp[i-1]);
            //한칸씩 건너뜀, 두칸씩 건너뜀, 앞앞과 앞 모두 다 거침
        }

        System.out.println(dp[n]);
    }
}
