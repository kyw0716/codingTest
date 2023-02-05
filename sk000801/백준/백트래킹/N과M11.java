package sk000801.백준.백트래킹;
import java.io.*;
import java.util.*;

//방문처리가 똑같은 수가 또 출력되도록 해야해서
//같은배열이 중복돼서 사용되는 경우만 제한?
public class N과M11 {
    static int n, m;
    static int[] num;
    static int[] ans;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer("");
    public static void dfs(int depth) {
        if(depth==m) {
            for(int i = 0; i < m; i++) {
                sb.append(ans[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(i >= 1 && num[i-1] == num[i] && !visited[i-1]) continue;
                ans[depth] = num[i];
                // visited[i] = true;
                dfs(depth+1);
                // visited[i] = false;
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

        dfs(0);

        System.out.println(sb);
    }
}
