package sk000801.복습;

//7분
public class _3n타일링 {
    //dp[0] = 1, dp[1] = 0, dp[2] = 3, dp[3] = 0
    public static long solution(int n) {
        long[] dp = new long[5001];
        long mod = 1_000_000_007;
        dp[0] = 1; dp[2] = 3;
        for(int i = 4; i <= n; i++) {
            if(i%2 == 1) continue;
            //나머지 값으로 계산을 하게되면 dp의 값이 커졌을 때 앞의 값이 mod보다 커져 dp[i]가 음수가 될 수 있다
            //그래서 0보다 작다면 mod를 더해준다.
            dp[i] = dp[i-2]*4%mod-dp[i-4]%mod;
            if(dp[i] < 0) dp[i] += mod;
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
