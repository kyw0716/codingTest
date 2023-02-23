package sk000801.백준.그래프;
import java.io.*;

//혼자 엉뚱한 생각을 해버렸다.. 회전이나 대칭을 시켜야 하기 때문에,,,?
//상하좌우로만 탐색이 가능한 거엿,,?
public class 테트로미노 {
    static int n, m;
    static int[][] paper;
    static int ans = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;
    // static int[][] dx = {{1,2,3}, {0,1,1},{0,0,1},{0,1,1},{1,1,2}};
    // static int[][] dy = {{0,0,0}, {1,1,0},{1,2,2},{1,1,2},{0,1,0}};
    // public static int poly(int r, int j) {
    //     int init = paper[r][j];
    //     int max = 0;
        
    //     for(int i = 0; i < 5; i++) {
    //         int res = 0;
    //         int count = 0;
    //         for(int x = 0; x < 3; x++) {
    //             int nx = r+dx[i][x];
    //             int ny = j+dy[i][x];

    //             if(nx<0||nx>=n||ny<0||ny>=m) break;
    //             res += paper[nx][ny];
    //             count++;
    //         }
    //         if(count==3) max = Math.max(max, res);
    //     }

    //     return init+max;
    // }
    public static void dfs(int y, int x, int count, int sum) {
        if(count>=4) {
            ans = Math.max(ans, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];

            if(nx<0||nx>=m||ny<0||ny>=n||visited[ny][nx]) continue;
            visited[ny][nx] = true;
            dfs(ny, nx, count+1, sum+paper[ny][nx]);
            visited[ny][nx] = false;
        }
    }
    public static void check(int y, int x) {
        if (y < n - 2 && x < m - 1)
            ans = Math.max(ans, paper[y][x] + paper[y + 1][x] + paper[y + 2][x] + paper[y + 1][x + 1]);

        if (y < n - 2 && x > 0)
            ans = Math.max(ans, paper[y][x] + paper[y + 1][x] + paper[y + 2][x] + paper[y + 1][x - 1]);

        if (y < n - 1 && x < m - 2)
            ans = Math.max(ans, paper[y][x] + paper[y][x + 1] + paper[y][x + 2] + paper[y + 1][x + 1]);

        if (y > 0 && x < m - 2)
            ans = Math.max(ans, paper[y][x] + paper[y][x + 1] + paper[y][x + 2] + paper[y - 1][x + 1]);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        paper = new int[n][m];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(s[j]);
            }
        }

        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                visited[i][j] = false;
                check(i, j);
            }
        }

        System.out.println(ans);
        // int max = 0;
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         max = Math.max(max, poly(i, j));
        //     }
        // }

        // System.out.println(max);
    }
}
