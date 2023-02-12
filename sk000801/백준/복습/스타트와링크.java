package sk000801.백준.복습;
import java.util.*;

public class 스타트와링크 {
    static int n;
    static int[][] power;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void dfs(int depth) {
        if(depth==n/2) {
            int a = 0;
            int b = 0;
            for(int i = 0; i < n-1; i++) {
                for(int j = i+1; j < n; j++) {
                    if(visited[i] && visited[j]) {
                        a += power[i][j]+power[j][i];
                    }
                    else if(!visited[i] && !visited[j]) {
                        b += power[i][j]+power[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(a-b));
            return;
        }

        for(int r = 0; r < n; r++) {
            if(visited[r]) continue;
            visited[r] = true;
            dfs(depth+1);
            visited[r] = false;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        power = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                power[i][j] = in.nextInt();
            }
        }

        dfs(0);

        System.out.println(min);
    }
}
