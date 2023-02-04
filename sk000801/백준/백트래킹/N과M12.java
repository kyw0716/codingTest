package sk000801.백준.백트래킹;
import java.io.*;
import java.util.*;

public class N과M12 {
    static int n, m;
    static int[] num;
    static int[] ans;
    static StringBuffer sb = new StringBuffer("");

    public static void dfs(int idx, int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int jeon = -1;
        for(int i = idx; i < n; i++) {
            int hoo = num[i];
            if(jeon != hoo) {
                jeon = hoo;
                ans[depth] = num[i];
                dfs(i, depth+1);
                //자기 자신을 호출해야 재귀임!
            }
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

        dfs(0, 0);

        System.out.println(sb);
    }
}