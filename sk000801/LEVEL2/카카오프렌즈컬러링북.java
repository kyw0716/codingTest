package sk000801.LEVEL2;
//단순 bfs 문제, 근데 큐에서 poll()을 안해서 헤맴 .. 
//30분!
import java.util.*;
class Solution {
    int maxArea = 0;
    int numArea = 0;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    public void bfs(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    int val = picture[i][j];
                    int max = 1;
                    
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        for(int r = 0; r < 4; r++) {
                            int nx = cur[0]+dx[r];
                            int ny = cur[1]+dy[r];

                            if(nx<0||nx>=m||ny<0||ny>=n) continue;
                            if(!visited[nx][ny] && picture[nx][ny] == val) {
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                                max++;
                            }
                        }
                    }
                    
                    maxArea = Math.max(maxArea, max);
                    numArea++;         
                }             
            }
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        bfs(m, n, picture);
        return new int[]{numArea, maxArea};
    }
}
