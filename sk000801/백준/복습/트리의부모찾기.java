package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 트리의부모찾기 {
    static int n;
    static boolean[] visited;
    static int[] ans;
    static List<List<Integer>> list = new ArrayList<>();
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int top = q.poll();
            for(Integer num : list.get(top)) {
                if(!visited[num]) {
                    visited[num] = true;
                    q.add(num);
                    ans[num] = top;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        ans = new int[n+1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs();

        for(int i = 2; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
}
