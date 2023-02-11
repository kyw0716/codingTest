package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 촌수계산 {
    static int n;
    static int[][] parent;
    static int[] result;
    static int count = 0;
    public static void bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);

        while(!q.isEmpty()) {
            int top = q.poll();

            for(int i = 1; i <= n; i++) {
                if(parent[top][i] == 1 && result[i] == 0) {
                    q.add(i);
                    result[i] = result[top]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        parent = new int[n+1][n+1];
        result = new int[n+1];

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            parent[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
            parent[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;
        }

         bfs(a, b);

         System.out.println(result[b] == 0 ? -1 : result[b]); 
    }
}
