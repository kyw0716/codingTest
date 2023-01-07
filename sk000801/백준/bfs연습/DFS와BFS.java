package sk000801.백준.bfs연습;
import java.io.*;
import java.util.*;

public class DFS와BFS {
    static int n;
    static int[][] node;
    static boolean[] visited;
    static StringBuffer sb;
    static Queue<Integer> q = new LinkedList<>();

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start+" ");

        for(int i = 0; i <= n; i++) {
            if(node[start][i] == 1 && !visited[i]) dfs(i);
        }
    }

    public static void bfs(int start) {
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start+" ");

            for(int i = 1; i <= n; i++) {
                if(node[start][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        sb = new StringBuffer("");

        n = in.nextInt();
        node = new int[n+1][n+1];
        visited = new boolean[n+1];
        int m = in.nextInt();
        int v = in.nextInt();
        for(int i = 1; i <= m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            node[a][b] = 1;
            node[b][a] = 1;
        }

        dfs(v);
        
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v);

        System.out.println(sb);
    }
}