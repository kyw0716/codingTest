package sk000801.백준.복습;
import java.io.*;
import java.util.*;

//1->u->v->n
//1->v->u->n
//최단 -> 우선순위 큐 + 거리 담는 배열(?)
public class 특정한최단경로 {
    static int n, e;
    static int u, v;
    static int[] dist;
    static List<List<Node>> list = new ArrayList<>();
    public static class Node implements Comparable<Node>{
        int node; int cost;
        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost-n.cost;
        }
    }
    public static void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.node] < cur.cost) continue;

            for(Node next : list.get(cur.node)) {
                if(dist[next.node] > cur.cost+next.cost) {
                    dist[next.node] = cur.cost+next.cost;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        dist = new int[n+1];
        e = Integer.parseInt(s[1]);

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        s = br.readLine().split(" ");
        u = Integer.parseInt(s[0]);
        v = Integer.parseInt(s[1]);

        int min1 = 0; int min2 = 0;
        
        bfs(1);
        min1 += dist[u];
        min2 += dist[v];

        bfs(u);
        min1 += dist[v];
        min2 += dist[n];

        bfs(v);
        min1 += dist[n];
        min2 += dist[u];

        if(min1 >= Integer.MAX_VALUE && min2 >= Integer.MAX_VALUE) {System.out.println(-1); return;}

        System.out.println(Math.min(min1, min2));
    }
}
