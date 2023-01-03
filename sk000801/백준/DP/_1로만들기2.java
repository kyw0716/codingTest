package sk000801.백준.DP;
import java.io.*;

//12852번

public class _1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int[] trace = new int[n+1];

        StringBuffer sb = new StringBuffer("");

        dp[1] = 0;
        trace[1] = -1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+1;
            trace[i] = i-1;

            if(i%2==0 && dp[i] > dp[i/2]+1) {
                dp[i] = dp[i/2]+1;
                trace[i] = i/2;
            } 
            if(i%3==0 && dp[i] > dp[i/3]+1) {
                dp[i] = dp[i/3]+1;
                trace[i] = i/3;
            }
        }

        int num = dp[n];
        int index = n;

        System.out.println(num);

        for(int i = 0; i <= num; i++) {
            System.out.print(index+" ");
            index = trace[index];
        }
    }   
}
