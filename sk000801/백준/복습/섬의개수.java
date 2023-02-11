package sk000801.백준.복습;
import java.util.*;

public class 섬의개수 {
    static int a,b;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0,1,-1,1,-1};
    static int[] dy = {0,-1,0,1,1,-1,-1,1};
    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int r = 0; r < 8; r++) {
                int nx = top[0]+dx[r];
                int ny = top[1]+dy[r];

                if(nx<0||nx>=b||ny<0||ny>=a) continue;
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        while(true) {
            a = in.nextInt();
            b = in.nextInt();
            if(a == 0 && b == 0) break;
            map = new int[b][a];
            visited = new boolean[b][a];
            
            for(int i = 0; i < b; i++) {
                for(int j = 0; j < a; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            int count = 0;
            for(int i = 0; i < b; i++) {
                for(int j = 0; j < a; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}