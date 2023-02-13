package sk000801.백준.복습;
import java.util.*;

public class 암호만들기 {
    static int l, c;
    static char[] mj;
    static char[] ans;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer("");
    public static boolean check(char[] c) {
        int count = 0;
        for(int i = 0; i < c.length; i++) {
            if(c[i]=='a' || c[i]=='e' || c[i]=='i' || c[i]=='o' || c[i]=='u') count++;
            if(i<c.length-1 && c[i] > c[i+1]) return false;
        }
        if(count<1) return false;
        return true;
    }
    public static void dfs(int depth) {
        if(depth == l) {
            if(check(ans)) {
                for(char c : ans) {
                    sb.append(c).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = 0; i < c; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = mj[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] s = in.nextLine().split(" ");
        l = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        ans = new char[l];
        visited = new boolean[c];
        mj = new char[c];

        s = in.nextLine().split(" ");
        for(int i = 0; i < c; i++) {
            mj[i] = s[i].charAt(0);
        }
        Arrays.sort(mj);

        dfs(0);

        System.out.println(sb);
    }
}
