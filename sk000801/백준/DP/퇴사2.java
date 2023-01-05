package sk000801.백준.DP;
import java.io.*;
import java.util.StringTokenizer;

public class 퇴사2 {
    static int n;
    static int[] time;
    static int[] cost;
    static long[] dp;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        time = new int[n+2];
        cost = new int[n+2];
        dp = new long[n+2];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken()); //상담기간
            cost[i] = Integer.parseInt(st.nextToken()); //상담비용
        }

        max = 0;
        for(int i = 1; i <= n+1; i++) {
            max = Math.max(max, dp[i]);
            if(i+time[i] <= n+1) {
                dp[i+time[i]] = Math.max(max+cost[i], dp[i+time[i]]);
            }
        }

        System.out.println(max);
    }
}

//아마도 퇴사보다는 주어진 값이 커져 효율적인 dp가 필요했던듯..
//잊지 말자 dp는 점화식을 통해 값을 더해간다..!
//마지막 날짜를 포함하려면 퇴사날짜(n+1)일 때 최대 금액을 찾아야 하므로 인덱스가 n+2가 됨
