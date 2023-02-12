package sk000801.백준.복습;
import java.util.*;

public class 부분수열의합 {
    static int n;
    static int val;
    static int[] num;
    static int ans = 0;
    public static void dfs(int depth, int sum) {
        if(depth == n) {
            if(sum == val) ans++;
            return;
        }
        
        dfs(depth+1, sum+num[depth]);
        dfs(depth+1, sum);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        num = new int[n];
        val = in.nextInt();
        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        dfs(0,0);

        System.out.println(val == 0? ans-1 : ans);
        //정답값이 0이라면 아예 없을 경우도 계산하므로
    }
}
