package sk000801.백준.백트래킹;
import java.io.*;
import java.util.*;

// 근데 이게 도대체 왜 9랑 무슨 차이,,
public class N과M10 {
    static int n, m;
    static int[] num;
    static int[] ans;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer("");
    public static void dfs(int idx, int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(ans[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i < n; i++) {
            if(!visited[i]) {
                if(i >= 1 && num[i-1] == num[i] && !visited[i-1]) continue;
                ans[depth] = num[i];
                visited[i] = true;
                dfs(i, depth+1);
                visited[i] = false;
            }
            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        num = new int[n];
        ans = new int[m];
        visited = new boolean[n];

        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(num);

        dfs(0, 0);

        System.out.println(sb);
    }
}
