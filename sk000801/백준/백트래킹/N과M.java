package sk000801.백준.백트래킹;
import java.util.*;

public class N과M {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] num;

    public static void dfs(int count) {
        if(count == m) {
            for(int j = 0; j < m; j++) {
                System.out.print(num[j]+ " ");
            }
            System.out.print("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            num[count] = i;
            dfs(count+1);
            visited[i] = false;
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
