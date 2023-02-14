package sk000801.백준.복습;
import java.io.*;

public class 연결요소의개수 {
    static int n;
    static int[][] node;
    static boolean[] visited;
    public static void dfs(int i) {    
        for(int x = 1; x <= n; x++) {
            if(!visited[x] && node[i][x] == 1) {
                visited[x] = true;
                dfs(x);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        node = new int[n+1][n+1];
        visited = new boolean[n+1];
        int m = Integer.parseInt(s[1]);

        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            node[a][b] = node[b][a] = 1;
        }

        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}
