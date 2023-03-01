package sk000801.LEVEL2;
import java.util.*;
class Solution {
    int n, m;
    int[][] visited;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    public void bfs(int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = 1;
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()) {
            int[] top = q.poll();
            if(top[0] == n-1 && top[1] == m-1) return;
            
            for(int i = 0; i < 4; i++) {
                int nx = top[0]+dx[i];
                int ny = top[1]+dy[i];
                
                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if(map[nx][ny] == 1 && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[top[0]][top[1]]+1;
                    q.add(new int[]{nx, ny});
                } 
            }
        }
    }
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = -1;
            }
        }
        
        bfs(maps);
        
        return visited[n-1][m-1];
    }
}
