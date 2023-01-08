package sk000801.백준.bfs연습;
import java.io.*;
import java.util.*;

public class 섬의개수 {

    static int w;
    static int h;
    static int[][] island;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1,-1,-1,1,1};
    static int[] dy = {1,0,-1,0,-1,1,1,-1};
    static Queue<int[]> q;

    public static void bfs(int i, int j) {
        q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] jap = q.poll();
            for(int p = 0; p < 8; p++) {
                int nx = jap[0]+dx[p];
                int ny = jap[1]+dy[p];
                if(nx < 0 || ny >= w || ny < 0 || nx >= h) continue;
                if(!visited[nx][ny] && island[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            island = new int[h][w];
            visited = new boolean[h][w];

            if(w==0 && h==0) {System.out.println(sb); return;}

            for(int i = 0; i < h; i++) {
                String[] s = br.readLine().split(" ");
                for(int j = 0; j < w; j++) {
                    island[i][j] = Integer.parseInt(s[j]);
                }
            }

            int count = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(!visited[i][j] && island[i][j] == 1) {bfs(i, j);count++;}
                }
            }

            sb.append(count);
            sb.append("\n");
        }
    }
}
