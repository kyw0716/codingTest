package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 최소스패닝트리2 {
    static int v, e;
    static List<List<Node>> list = new ArrayList<>();

    public static class Node implements Comparable<Node> {
        int node, cost;
        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node node) {
            return this.cost-node.cost;
        }
    }
    public static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v+1];
        pq.add(new Node(1, 0));
        
        long ans = 0;
        long idx = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            ans += cur.cost;
            visited[cur.node] = true;
            if(++idx == v) {System.out.println(ans); return;}

            for(Node next : list.get(cur.node)) {
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
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        prim();
    }
}
