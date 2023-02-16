package sk000801.백준.복습;
import java.io.*;
import java.util.*;

//키워드 기억하기! 위상정렬!
public class 줄세우기 {
    static int n, m;
    static int[] indegree;
    static List<List<Integer>> list = new ArrayList<>();
    static StringBuffer sb = new StringBuffer("");
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);

            for(Integer next : list.get(cur)) {
                indegree[next]--;
                if(indegree[next] == 0) q.add(next);
            }
        }

        while(!ans.isEmpty()) {
            sb.append(ans.poll()+ " ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        indegree = new int[n+1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            list.get(a).add(b);
            indegree[b]++;
        }

        bfs();

        System.out.println(sb);
    }
}
