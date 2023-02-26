package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 최단경로2 {
    static int v, e;
    static List<List<Node>> list = new ArrayList<>();
    static int[] dist;
    public static class Node implements Comparable<Node> {
        int dot, cost;
        public Node(int dot, int cost) {
            this.dot = dot;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node n) {
            return this.cost-n.cost;
        }
    }
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.cost > dist[cur.dot]) continue;

            for(Node next : list.get(cur.dot)) {
                if(dist[next.dot] > dist[cur.dot]+next.cost) {
                    dist[next.dot] = dist[cur.dot]+next.cost;
                    pq.add(new Node(next.dot, dist[next.dot]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        dist = new int[v+1];
        int start = Integer.parseInt(br.readLine());

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            list.get(a).add(new Node(b, c));
        }

        dijkstra(start);

        for(int i = 1; i <= v; i++) {
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
