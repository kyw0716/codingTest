package sk000801.LEVEL3;
import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int max = 0;
    int[] dist;
    boolean[] visited;
    public void dijkstra(int start,int n) {
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0;
        visited[start] = true;
        q.add(start);     
        while(!q.isEmpty()) {
            int cur = q.poll();
              
            for(Integer next : list.get(cur)) {
                if(visited[next]) continue;
                dist[next] = dist[cur]+1;
                visited[next] = true;
                max = Math.max(dist[next], max);
                q.add(next);
            }
        }
        
    }
    public int solution(int n, int[][] edge) {
        dist = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i <= edge.length; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        dijkstra(1, n);
        
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(max == dist[i]) answer++;
        }
        return answer;
    }
}