package sk000801.백준.복습;
import java.io.*;

public class 동전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] num = new int[n];
        int[] dp = new int[k+1];
        dp[0] = 0;

        for(int i = 1; i <= k; i++) {
            dp[i] = 100_000;
        }

        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++) {
            for(int j = num[i]; j <= k; j++) {
                if(num[i] <= j) dp[j] = Math.min(dp[j], dp[j-num[i]]+1);
                //k의 가치를 만들어 낼 수 있는 숫자들 중 더 작은 숫자를 골라야 하므로
                //그래서 dp의 값들을 큰 값으로 초기화 시킴
            }
        }

        System.out.println(dp[k] == 100_000 ? -1 : dp[k]);
    }
}
