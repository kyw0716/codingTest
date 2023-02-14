package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

//1 -> x -> y -> N
//1 -> y -> x -> N
public class 특정한최단경로 {
    static int n,e;
    static List<List<Node>> list = new ArrayList<>();
    static int[] dist;
    public static class Node implements Comparable<Node> {
        int jum;
        int dist;

        public Node(int jum, int dist) {
            this.jum = jum;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return this.dist-n.dist;
        }
    }
    public static void dijkstra(int start) {
        for(int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();

            if(n.dist > dist[n.jum]) continue;

            int len = list.get(n.jum).size();
            for(int i = 0; i < len; i++) {
                Node next = list.get(n.jum).get(i);

                if(dist[next.jum] > n.dist + next.dist) {
                    dist[next.jum] = n.dist+next.dist;
                    pq.add(new Node(next.jum, dist[next.jum]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        dist = new int[n+1];

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b,c));
            list.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dijkstra(1);
        long c1 = dist[v1];
        long c2 = dist[v2];

        dijkstra(v1);
        c1 += dist[v2];
        c2 += dist[n];

        dijkstra(v2);
        c1 += dist[n];
        c2 += dist[v1];

        if(c1 >= Integer.MAX_VALUE && c2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(c1, c2));
    }
}
