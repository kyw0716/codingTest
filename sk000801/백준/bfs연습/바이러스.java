package sk000801.백준.bfs연습;
import java.util.*;

public class 바이러스 {
    static int n;
    static int[][] com;
    static boolean[] visited;
    static int count = 0;
    public static void dfs(int n) {
        if(visited[n]) return;

        visited[n] = true;
        count += 1;

        for(int i = 1; i < com[n].length; i++) {
            if(com[n][i]==1 && !visited[i]) dfs(i);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        com = new int[n+1][n+1];
        visited = new boolean[n+1];
        int tc = in.nextInt();

        for(int i = 1; i <= tc; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            com[a][b] = 1;
            com[b][a] = 1;
        }

        dfs(1);

        System.out.println(count-1);
    }
}
