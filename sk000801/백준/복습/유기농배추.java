package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 유기농배추 {
    static int m,n;
    static int[][] land;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static StringBuffer sb = new StringBuffer("");
    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] top = q.poll();
            
            for(int r = 0; r < 4; r++) {
                int nx = top[0]+dx[r];
                int ny = top[1]+dy[r];

                if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                if(!visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int r = 0; r < tc; r++) {
            String[] s = br.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            land = new int[m][n];
            visited = new boolean[m][n];
            int k = Integer.parseInt(s[2]);

            for(int i = 0; i < k; i++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                land[a][b] = 1;
            }

            int count = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(land[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }  
        System.out.println(sb);
    }
}