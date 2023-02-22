package sk000801.백준.복습;
import java.io.*;

public class 집합의표현 {
    static int n, m;
    static int[] parent;
    static StringBuffer sb = new StringBuffer("");
    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    public static void union(int x, int y) {
        if(x==y) return;
        int a = find(x);
        int b = find(y);

        if(a<b) parent[b] = a;
        else if(a>b) parent[a] = b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        parent = new int[n+1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            if(s[0].equals("0")) union(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            else {
                if(find(Integer.parseInt(s[1])) != find(Integer.parseInt(s[2]))) {
                    sb.append("no\n");
                    continue;
                } else {
                    sb.append("yes\n");
                }
            }
        }

        System.out.println(sb);
    }
}
