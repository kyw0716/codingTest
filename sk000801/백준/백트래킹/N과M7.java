package sk000801.백준.백트래킹;
import java.io.*;
import java.util.*;

public class N과M7 {
    static int n, m;
    static int[] num;
    static int[] ans;
    static StringBuffer sb = new StringBuffer("");
    public static void dfs(int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(ans[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            ans[depth] = num[i];
            dfs(depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        ans = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        dfs(0);

        System.out.println(sb);
    }
}
