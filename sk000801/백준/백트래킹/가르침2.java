package sk000801.백준.백트래킹;
import java.io.*;
import java.util.*;

public class 가르침2 {
    static int n, m;
    static boolean[] visited = new boolean[26]; //알파벳
    static String[] s;
    static int max = 0;
    public static void dfs(int idx, int depth) {
        if(depth == m-5) {
            int count = 0;
            for(int i = 0; i < n; i++) {
                boolean visit = true;
                for(int j = 0; j < s[i].length(); j++) {
                    if(!visited[(int)s[i].charAt(j)-97]) {
                        visit = false; break;
                    }
                }
                if(visit) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = idx; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ss = br.readLine().split(" ");
        n = Integer.parseInt(ss[0]);
        m = Integer.parseInt(ss[1]);
        s = new String[n];

        for(int i = 0; i < n; i++) {
            s[i] = br.readLine();
            s[i] = s[i].replace("anta", "");
            s[i] = s[i].replace("tica", "");
        }

        if(m<5) {System.out.println(0); return;}
        else if(m == 26) {System.out.println(n); return;}
        visited[0] = true; visited[2] = true; visited[8] = true;
        visited[13] = true; visited[19] = true;
        
        dfs(0, 0);     

        System.out.println(max);
    }
}
