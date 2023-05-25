package sk000801.복습;
import java.util.*;

public class 가장먼노드 {
    static int[] dist;
    static boolean[] visited;
    static List<List<Integer>> list;
    static int max = 0;
    public static void dijkstra(int start, int n) {
        Queue<Integer> q =  new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        visited[start] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(int p : list.get(node)) {
                if(!visited[p]) {
                    dist[p] = dist[node]+1;
                    visited[p] = true;
                    max = Math.max(max, dist[p]);
                    q.add(p);
                }
            }
        }
    }
    public static int solution(int n, int[][] vertex) {
        dist = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < vertex.length; i++) {
            list.get(vertex[i][0]).add(vertex[i][1]);
            list.get(vertex[i][1]).add(vertex[i][0]);
        }

        dijkstra(1, n);

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(max == dist[i]) answer++;
        }
        
        return answer;
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};	
        System.out.println(solution(n, vertex));
    }
}
