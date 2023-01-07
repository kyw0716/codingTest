package sk000801.백준.브루트포스;
import java.io.*;
import java.util.*;

public class 유기농배추 {
    static int m;
    static int n;

    static int[][] baechu;
    static boolean[][] visited;
    static int min;
    static Queue<int[]> q;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs(int row, int col) {
        q = new LinkedList<>();
        q.add(new int[]{row, col});

        while(!q.isEmpty()) {
            int[] jap = q.poll();
            visited[jap[0]][jap[1]] = true;
            for(int i = 0; i < 4; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];
                if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                if(visited[nx][ny] || baechu[nx][ny]==0) continue;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());

        for(int j = 0; j < tc; j++) {
            String[] s = br.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            visited = new boolean[m][n];
            baechu = new int[m][n];
            min = 0;
            for(int i = 0; i < k; i++) {
                String[] ss = br.readLine().split(" ");
                int x = Integer.parseInt(ss[0]);
                int y = Integer.parseInt(ss[1]);
                baechu[x][y] = 1;
            }

            for(int i = 0; i < m; i++) {
                for(int p = 0; p < n; p++) {
                    if(baechu[i][p]==1 && !visited[i][p]) {
                        bfs(i, p);
                        min++;
                    }
                }
            }

            System.out.println(min);
        }
    }
}
