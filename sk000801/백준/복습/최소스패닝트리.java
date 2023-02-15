package sk000801.백준.복습;
import java.util.*;
import java.io.*;

public class 최소스패닝트리 {
    static List<List<Tree>> list = new ArrayList<>();
    static int v, e;
    static long answer = 0;
    public static class Tree implements Comparable<Tree> {
        int node, cost;
        public Tree(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Tree t) {
            return this.cost-t.cost;
        }
    }
    public static void bfs() {
        boolean[] visited = new boolean[v+1];
        PriorityQueue<Tree> pq = new PriorityQueue<>(); 
        pq.add(new Tree(1, 0));

        long idx = 0;

        while(!pq.isEmpty()) {
            Tree cur = pq.poll();
            if(visited[cur.node]) continue;
            visited[cur.node] = true;

            answer += cur.cost;
            if(++idx == v) return;

            int len = list.get(cur.node).size();
            for(int j = 0; j < len; j++) {
                Tree next = list.get(cur.node).get(j);
                if(visited[next.node]) continue;
                pq.add(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);

        for(int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            list.get(a).add(new Tree(b, c));
            list.get(b).add(new Tree(a, c));
        }

        bfs();

        System.out.println(answer);
    }
}
