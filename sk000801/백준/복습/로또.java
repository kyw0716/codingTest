package sk000801.백준.복습;
import java.util.*;

public class 로또 {
    static int n;
    static int[] num;
    static int[] ans;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer("");
    public static boolean check(int[] num) {
        for(int i = 0; i < num.length-2; i++) {
            if(num[i] > num[i+1]) return false;
        }
        return true;
    }
    public static void dfs(int depth) {
        if(depth == 6) {
            if(check(ans)) {
                for(int i = 0; i < 6; i++) {
                    sb.append(ans[i]).append(" ");
                }
            }
            
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                ans[depth] = num[i];
                visited[i] = true;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            n = in.nextInt();
            if(n==0) break;
            num = new int[n];
            ans = new int[6];
            visited = new boolean[n];

            for(int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }

            dfs(0);

            sb.append("\n");
        }  

        System.out.println(sb);
    }
}
