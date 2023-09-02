package sk000801.백준.그래프;
import java.util.*;

// dfs 찾아 20분
public class ABCDE {
    static int n;
    static int m;
    static List<List<Integer>> friends = new ArrayList<>();
    static int ans = 0;
    static boolean[] visited;

    public static void dfs(int start, int depth) {
        if(depth == 5) {
            ans = 1;
            return;
        }

        visited[start] = true;
        for(int i = 0; i < friends.get(start).size(); i++) {
            int next = friends.get(start).get(i);
            if(!visited[next]) dfs(next, depth+1);
        }
        visited[start] = false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            friends.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        for(int i = 1; i <= n; i++) {
            if(ans == 0) {
                dfs(i, 1);
            }
        }

        System.out.println(ans);
    }
}
