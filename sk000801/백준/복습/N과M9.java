package sk000801.백준.복습;
import java.util.*;

public class N과M9 {
    static int n, m;
    static int[] num;
    static boolean[] visited;
    static int[] ans;
    static StringBuffer sb = new StringBuffer("");
    public static void dfs(int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(ans[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(i>=1 && num[i-1] == num[i] && !visited[i-1]) continue;
                visited[i] = true;
                ans[depth] = num[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        num = new int[n];
        ans = new int[m];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        Arrays.sort(num);

        dfs(0);

        System.out.println(sb);
    }
}
