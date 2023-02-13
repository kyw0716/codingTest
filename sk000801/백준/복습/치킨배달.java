package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 치킨배달 {
    static int n, m;
    static boolean[] visited;
    static int[][] ans;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static int calDist(int[] home) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < ans.length; i++) {
            int[] chi = ans[i];
            min = Math.min(min, Math.abs(chi[0]-home[0])+Math.abs(chi[1]-home[1]));
        }
        return min;
    }

    public static void dfs(int depth) {
        if(depth == m) {
            int res = 0;
            for(int i = 0; i < home.size(); i++) {
                res += calDist(home.get(i));
            }
            min = Math.min(min, res);
            return;
        }

        for(int i = 0; i < chicken.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = chicken.get(i);
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 2) {
                    chicken.add(new int[]{i, j});
                }
                if(a == 1) {
                    home.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[chicken.size()];
        ans = new int[m][2];

        dfs(0);

        System.out.println(min);
    }
}
