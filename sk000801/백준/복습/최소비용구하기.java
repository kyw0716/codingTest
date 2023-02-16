package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 최소비용구하기 {
    static int n;
    static int fin;
    static int[] dist;
    static List<List<Node>> list = new ArrayList<>();
    public static class Node implements Comparable<Node> {
        int next; int cost;
        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost-n.cost;
        }
    }
    public static void bfs(int start) {
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(!visited[cur.next]) {
                visited[cur.next] = true;

                for(Node next : list.get(cur.next)) {
                    if(!visited[next.next] && dist[next.next] > dist[cur.next]+next.cost) {
                        dist[next.next] = dist[cur.next]+next.cost;
                        q.add(new Node(next.next, dist[next.next]));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new int[n+1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            list.get(a).add(new Node(b, c));
        }

        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        fin = Integer.parseInt(s[1]);

        bfs(start);

        System.out.println(dist[fin]);
    }
}
