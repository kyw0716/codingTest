package sk000801.백준.브루트포스;
import java.io.*;
import java.util.*;

//원래는 빙산의 원래 값으로 주변 빙하의 녹는 높이를 계산해줘야 해서
//배열을 두 개 설정하는 방식을 택했으나
//bfs방식으로 방문 배열을 선언해 계산하기로 함
public class 빙산 {
    static int n, m;
    static int[][] ice;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    
    public static void melt() {
        Queue<int[]>  q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(ice[i][j] != 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] top = q.poll();
            int zero = 0;

            for(int i = 0; i < 4; i++) {
                int nx = top[0]+dx[i];
                int ny = top[1]+dy[i];

                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(!visited[nx][ny] && ice[nx][ny] == 0) zero++;
            }

            if(ice[top[0]][top[1]] - zero < 0) ice[top[0]][top[1]] = 0;
            else ice[top[0]][top[1]] -= zero;
        }
    }
    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||nx>=n||ny<0||ny>=m) continue;
            if(ice[nx][ny] != 0 && !visited[nx][ny]) dfs(nx, ny, visited);
        }
    }
    public static int check() {
        boolean[][] visited = new boolean[n][m];
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(ice[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        ice = new int[n][m];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                ice[i][j] = Integer.parseInt(s[j]);
            }
        }

        int ans = 0;
        int count = 0;
        while((count = check()) < 2) {
            if(count == 0) {
                System.out.println(0);
                return;
            }
            
            melt();
            ans++;
        }

        System.out.println(ans);
    }
}
