package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

public class 네트워크연결 {
    static int n;
    static int m;
    static ArrayList<ArrayList<Node>> list;
    static boolean[] visited;
    public static class Node implements Comparable<Node> {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost-n.cost;
        }
    }
    public static void prim(int start, int n) {
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int total = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dest = node.dest;
            int cost = node.cost;

            if(visited[dest]) continue;

            visited[dest] = true;
            total += cost;

            for(Node no : list.get(dest)) {
                pq.add(no);
            }
        }

        System.out.println(total);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(new Node(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
            list.get(Integer.parseInt(s[1])).add(new Node(Integer.parseInt(s[0]), Integer.parseInt(s[2])));
        }

        prim(1, n);
    }
}
