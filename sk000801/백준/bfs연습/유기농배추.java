package sk000801.백준.bfs연습;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
    static int n;
    static int m;
    static int[][] bat;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] jap = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = jap[0] + dx[i];
                int ny = jap[1] + dy[i];
                if(nx<0 || nx>m || ny<0 || ny>n) continue;
                if(bat[nx][ny]==0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");

        int tc = Integer.parseInt(br.readLine());
        for(int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int gaesu = Integer.parseInt(st.nextToken());

            bat = new int[m][n];
            visited = new boolean[m][n];
            for(int j = 0; j < gaesu; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                bat[a][b] = 1;
            }

            int count = 0;
            for(int x = 0; x < m; x++) {
                for(int y = 0; y < n; y++) {
                    if(bat[x][y]==1 && !visited[x][y]) {bfs(x, y);count++;}
                }
            }

            sb.append(count);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
