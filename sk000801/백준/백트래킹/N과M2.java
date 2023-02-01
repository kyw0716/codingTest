package sk000801.백준.백트래킹;
import java.util.*;

public class N과M2 {
    static int n, m;
    static boolean[] visited;
    static int[] num;
    public static boolean check(int[] num) {
        for(int i = 0; i < num.length-1; i++) {
            if(num[i] >= num[i+1]) return false;
        }
        return true;
    }
    public static void dfs(int depth) {
        if(depth==m) {
            if(check(num)) {
                for(int i = 0; i < m; i++) {
                    System.out.print(num[i]+" ");
                }
                System.out.println();
            }
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                num[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        visited = new boolean[n+1];
        num = new int[m];

        dfs(0);
    }
}
