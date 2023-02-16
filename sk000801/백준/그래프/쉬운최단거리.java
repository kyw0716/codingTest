package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

public class 쉬운최단거리 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[] dest;
    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        map[i][j] = 0;
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int r = 0; r < 4; r++) {
                int nx = top[0]+dx[r];
                int ny = top[1]+dy[r];

                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    map[nx][ny] = map[top[0]][top[1]]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j] == 2) dest = new int[]{i, j};
            }
        }

        bfs(dest[0], dest[1]);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // if(!visited[i][j]) map[i][j] = 0;
                if(!visited[i][j] && map[i][j] == 1) map[i][j] = -1;
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
