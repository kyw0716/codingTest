package sk000801.백준.백트래킹;
import java.util.*;

public class N과M3 {
    static int n, m;
    static boolean[] visited;
    static int[] num;
    static StringBuffer sb = new StringBuffer("");
    public static void dfs(int depth) {
        if(depth==m) {
            for(int i = 0; i < m; i++) {
                sb.append(num[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            //if(!visited[i]) {
                num[depth] = i;
                //visited[i] = true;
                dfs(depth+1);
                //visited[i] = false;
            //}
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        num = new int[m];
        visited = new boolean[n+1];

        dfs(0);

        System.out.println(sb);
    }
}
