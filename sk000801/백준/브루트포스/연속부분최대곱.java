import java.util.*;

public class 연속부분최대곱 {
    static double max;
    static int n;
    static double[] nums;
    static double[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = (int) in.nextDouble();
        nums = new double[n+1];
        dp = new double[n+1];

        max = 0.0;

        for(int i = 1; i <= n; i++) {
            nums[i] = in.nextDouble();
            dp[i] = Math.max(nums[i], dp[i-1]*nums[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(String.format("%.3f", max));
    }
}
