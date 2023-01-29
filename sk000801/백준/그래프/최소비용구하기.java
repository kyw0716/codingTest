package sk000801.백준.그래프;
import java.util.*;

public class 최소비용구하기 {
    static int n;
    static ArrayList<ArrayList<Edge>> map;
    static int[] dist;

    public static class Edge implements Comparable<Edge> {
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost-e.cost;
        }
    }

    public static int dikstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        pq.offer(new Edge(start, 0));
        dist[start] = 0;  

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            int jap = e.node;

            if(!visited[jap]) {
                visited[jap] = true;

                for(Edge edge : map.get(jap)) {
                    if(!visited[edge.node] && dist[edge.node] > dist[jap] + edge.cost) {
                        dist[edge.node] = dist[jap] + edge.cost;
                        pq.add(new Edge(edge.node, dist[edge.node])); 
                    }
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());
        int m = Integer.parseInt(in.nextLine());
        map = new ArrayList<>();
        dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        //최소 거리 값을 저장하는 배열, 일단 초기값에 Integer의 max 값을 넣어줌 

        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<Edge>());
        }

        for(int i = 0; i < m; i++) {
            String[] s = in.nextLine().split(" ");
            map.get(Integer.parseInt(s[0])-1).add(new Edge(Integer.parseInt(s[1])-1, Integer.parseInt(s[2])));
        }

        String[] ss = in.nextLine().split(" ");
        int start = Integer.parseInt(ss[0])-1;
        int fin = Integer.parseInt(ss[1])-1;

        System.out.println(dikstra(start, fin));
    }
}