package sk000801.백준.복습;
import java.io.*;
import java.util.*;

//출발점이 정해져 있고, 방문 여부를 통해 다음 이동 정점이 정해짐
public class DFS와BFS {
    static int n, m;
    static int[][] node;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer("");
    public static void dfs(int v) {
        visited[v] = true;
        sb.append(v+" ");

        for(int i = 0; i <= n; i++) {
            if(node[v][i] == 1 && !visited[i]) dfs(i);
        }
    }
    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n+1];

        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int num = q.poll();
            sb.append(num+" ");

            for(int i = 1; i <= n; i++) {
                if(node[num][i] == 1 && !visited[i]) {q.add(i); visited[i] = true;}
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        node = new int[n+1][n+1];
        int v = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[a][b] = node[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }
}
