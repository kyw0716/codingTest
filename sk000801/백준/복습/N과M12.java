package sk000801.백준.복습;
import java.util.*;

public class N과M12 {
    static int n, m;
    static int[] num;
    static int[] ans;

    public static boolean check(int[] num) {
        for(int i = 0; i < num.length-1; i++) {
            if(num[i] > num[i+1]) return false;
        }
        return true;
    }

    public static void dfs(int idx, int depth) {
        if(depth == m) {
            if(check(num)) {
                for(int i = 0; i < m; i++) {
                    System.out.print(ans[i]+" ");
                }
                System.out.println();
            }
            return;
        }

        int before = -1;
        for(int i = idx; i < n; i++) {
            int after = num[i];
            if(before != after) {
                before = after;
                ans[depth] = num[i];
                dfs(i, depth+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        num = new int[n];
        ans = new int[m];

        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        Arrays.sort(num);

        dfs(0, 0);
    }
}
