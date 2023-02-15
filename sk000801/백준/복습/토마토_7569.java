package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 토마토_7569 {
    static int m,n,h;
    static int[][][] tom;
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,-1,0,1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<int[]>  q = new LinkedList<>();
    public static void bfs() {
        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int i = 0; i < 6; i++) {
                int nx = top[0]+dx[i];
                int ny = top[1]+dy[i];
                int nz = top[2]+dz[i];

                if(nx<0||nx>=n||ny<0||ny>=m||nz<0||nz>=h) continue;
                if(tom[nx][ny][nz] == 0) {
                    tom[nx][ny][nz] = tom[top[0]][top[1]][top[2]] + 1;
                    q.add(new int[]{nx, ny, nz});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tom = new int[n][m][h];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int r = 0; r < m; r++) {
                    tom[j][r][i] = Integer.parseInt(st.nextToken());
                    if(tom[j][r][i] == 1) q.add(new int[]{j,r,i});
                }
            }
        }

        bfs();

        int max = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int r = 0; r < m; r++) {
                    if(tom[j][r][i] == 0) {System.out.println(-1); return;} 
                    max = Math.max(max, tom[j][r][i]);
                }
            }
        }

        System.out.println(max-1);
    }
}
