package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

public class 연구소 {
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int ans = 0;
    static boolean[][] vis;

    public static void dfs(int wall) {
        if(wall == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
       
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        int[][] map2 = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            map2[i] = map[i].clone();
        }

        while(!q.isEmpty()) {
            int[] jap = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if(map2[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    map2[nx][ny] = 2;
                }
            }
        }

        int area = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map2[i][j] == 0) area++;
            }
        }

        ans = Math.max(area, ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); 
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < m ;j++) {
                map[i][j] = Integer.parseInt(ss[j]);
            }
        }

        dfs(0);

        System.out.println(ans);
    }
}
