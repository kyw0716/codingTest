import java.util.*;

public class 외판원_순회2 {
    static int n;
    static int[][] price;
    static boolean[] visited;
    static int min;
    
    public static void dfs(int depth, int start, int first) {
        int hap = 0;
        if(depth == n) {
            if(price[start][first] == 0) return;
            hap += price[start][first];
            min = Math.min(min, hap);
            return;
        } else {
            for(int i = 0; i < n; i++) {
                if(visited[i] || price[start][i] == 0) continue;
                visited[i] = true;
                dfs(depth+1, start+1, first+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        price = new int[n][n];
        visited = new boolean[n];
        min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                price[i][j] = in.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 1);
        }

        System.out.println(min);

    }
}
