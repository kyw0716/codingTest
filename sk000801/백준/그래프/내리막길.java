package sk000801.백준.그래프;
import java.io.*;

//dp를 통해 시간 초과를 막음
//그리고 높이 기준 내리막길인데 그냥 내리막길로 이해했다.. 
//-1로 초기화 하는 이유는 이 경우의 수가 0일수도 있기 때문
public class 내리막길 {
    static int m, n;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static int dfs(int i, int j) {
        if(i == m-1 && j == n-1) {
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = 0;

        for(int x = 0; x < 4; x++) {
            int nx = i+dx[x];
            int ny = j+dy[x];

            if(nx<0||nx>=m||ny<0||ny>=n) continue;
            if(map[i][j] > map[nx][ny]) {
                dp[i][j] += dfs(nx, ny);
            }
        }
        return dp[i][j];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        map = new int[m][n];
        dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }
}
