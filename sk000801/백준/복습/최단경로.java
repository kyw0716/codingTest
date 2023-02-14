package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 최단경로 {
    static int v, e;
    static List<List<Node>> list = new ArrayList<>();
    static int[] dist;
    public static class Node implements Comparable<Node> {
        int fin;
        int cost;

        public Node(int fin, int cost) {
            this.fin = fin;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost-n.cost;
        }
    }
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();

            if(n.cost > dist[n.fin]) continue;

            int len = list.get(n.fin).size();
            for(int i = 0; i < len; i++) {
                Node next = list.get(n.fin).get(i);

                if(dist[next.fin] > n.cost + next.cost) {
                    dist[next.fin] = n.cost + next.cost;
                    pq.add(new Node(next.fin, dist[next.fin]));
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

        for(int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        int start = Integer.parseInt(br.readLine());

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
