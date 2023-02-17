package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 인구이동 {
    static int n, l, r;
    static int[][] nara;
    static boolean[][] visited;
    static List<int[]> list;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static int bfs(int x, int y) {
        list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        list.add(new int[]{x, y});
        int sum = nara[x][y];

        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = top[0]+dx[i];
                int ny = top[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(!visited[nx][ny] && Math.abs(nara[top[0]][top[1]]-nara[nx][ny]) >= l 
                && Math.abs(nara[top[0]][top[1]]-nara[nx][ny]) <= r) {
                    list.add(new int[]{nx, ny});
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    sum += nara[nx][ny];
                }
            }
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);
        nara = new int[n][n];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                nara[i][j] = Integer.parseInt(s[j]);
            }
        }

        int ans = 0;
        boolean escape = true;

        while(escape) {
            escape = false;
            visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        int sum = bfs(i, j);
                        if(list.size()>1) {
                            int value = sum/list.size();
                            for(int[] node : list) {
                                nara[node[0]][node[1]] = value;
                            }
                            escape = true;
                        }
                    }
                }
            }
            ans++;
        }

        System.out.println(ans-1);
    }  
}
