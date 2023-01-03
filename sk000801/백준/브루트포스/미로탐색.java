import java.io.*;
import java.util.*;

public class 미로탐색 {
    static int n;
    static int m;
    static int[][] miro;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static Queue<int[]> q;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs(int row, int col) {
        q = new LinkedList<>();
        q.add(new int[]{row, col});

        while(!q.isEmpty()) {
            int[] jap = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(visited[nx][ny] || miro[nx][ny]==0) continue;
                q.add(new int[]{nx, ny});
                miro[nx][ny] = miro[jap[0]][jap[1]]+1;
                visited[nx][ny] = true;
            }
        }

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        miro = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                miro[i][j] = Integer.parseInt(ss[j]);
            }
        }

        visited[0][0] = true;
        bfs(0, 0);

        System.out.println(miro[n-1][m-1]);
    }
}
