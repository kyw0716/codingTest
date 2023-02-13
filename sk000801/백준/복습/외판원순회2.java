package sk000801.백준.복습;
import java.util.*;

public class 외판원순회2 {
    static int n;
    static int first;
    static int[][] cost;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void dfs(int depth, int sum, int val) {
        if(depth == n && val == first) {
            min = Math.min(min, sum);
        }

        if(!visited[val]) {
            visited[val] = true;
            for(int i = 0; i < n; i++) {
                if(cost[val][i] != 0) dfs(depth+1, sum+cost[val][i], i); //이건 시작점 이후 다음 칸을 지정하는 dfs
            }
            visited[val] = false;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        cost = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cost[i][j] = in.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            first = i;
            dfs(0, 0, i); //이건 시작점을 지정해주는 dfs
        }

        System.out.println(min);
    }
}
