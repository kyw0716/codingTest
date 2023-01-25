package sk000801.백준.그래프;
import java.io.*;
import java.util.*;


public class 효율적인해킹2 {
    static int n;
    static ArrayList<ArrayList<Integer>> node;
    static boolean[] visited;
    static int count;
    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.add(i);

        while(!q.isEmpty()) {
            int idx = q.poll();

            for(int p : node.get(idx)) {
                if(!visited[p]) {
                    q.add(p);
                    visited[p] = true;
                    count++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        node = new ArrayList<ArrayList<Integer>>();
        int max = 0;
        StringBuffer sb = new StringBuffer("");

        for(int i = 0; i < n; i++) {
            node.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            node.get(Integer.parseInt(s[1])-1).add(Integer.parseInt(s[0])-1);
        }

        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            visited = new boolean[n];
            count = 0;
            bfs(i);
            result[i] = count;
            max = Math.max(count, max);
        }

        for(int i = 0; i < n; i++) {
            if(result[i] == max) {
                sb.append(i+1+" ");
            }
        }

        System.out.println(sb);
    }
}

