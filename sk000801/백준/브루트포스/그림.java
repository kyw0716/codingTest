import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 그림 {
    static int n;
    static int m;

    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int size = 0;

    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};

    public static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        int count1 = 0;

        while(!q.isEmpty()) {
            int[] jap = q.poll();
            count1++;
            for(int i = 0; i < 4; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];
                if(nx<0 || nx>=n || ny<0 || ny >= m) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        count++;
        if(count1 > 1) count1--;
        size = Math.max(size, count1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(ss[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) bfs(i, j);
            }
        }

        System.out.println(count);
        System.out.println(size);
    }
}
