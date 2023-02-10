package sk000801.백준.복습;
import java.util.*;

public class 바이러스 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[][] computer = new int[n+1][n+1];
        int m = Integer.parseInt(in.nextLine());

        for(int i = 0; i < m; i++) {
            String[] s = in.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            computer[a][b] = computer[b][a] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(1);
    
        while(!q.isEmpty()) {
            int num = q.poll();
            visited[num] = true;

            for(int i = 2; i <= n; i++) {
                if(!visited[i] && computer[num][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        int count = 0;
        for(int i = 2; i <= n; i++) {
            if(visited[i]) count++;
        }

        System.out.println(count);
    }
}
