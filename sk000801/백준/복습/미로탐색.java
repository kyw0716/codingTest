package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 미로탐색 {
    static int n, m;
    static int[][] miro;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int r = 0; r < 4; r++) {
                int nx = top[0]+dx[r];
                int ny = top[1]+dy[r];

                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if(visited[nx][ny] || miro[nx][ny] == 0) continue;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                miro[nx][ny] = miro[top[0]][top[1]]+1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        miro = new int[n][m];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                miro[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(0, 0);

        System.out.println(miro[n-1][m-1]);
    }
}
