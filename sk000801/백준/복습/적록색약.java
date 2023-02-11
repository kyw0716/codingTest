package sk000801.백준.복습;
import java.util.*;

public class 적록색약 {
    static int n;
    static String[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;
    public static void bfs(String s, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int r = 0; r < 4; r++) {
                int nx = top[0]+dx[r];
                int ny = top[1]+dy[r];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(!visited[nx][ny] && map[nx][ny].equals(s)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    public static void bfs2(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int r = 0; r < 4; r++) {
                int nx = top[0]+dx[r];
                int ny = top[1]+dy[r];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(!visited[nx][ny] && !map[nx][ny].equals("B")) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());
        map = new String[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] s = in.nextLine().split("");
            for(int j = 0; j < n; j++) {
                map[i][j] = s[j];
            }
        }

        //적록색맹X
        int count = 0;
        //적록색맹Y
        int count2 = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j].equals("B")) {
                    bfs("B", i, j);
                    count++;
                    count2++;
                }
                if(!visited[i][j] && map[i][j].equals("R")) {
                    bfs("R", i, j);
                    count++;
                }
                if(!visited[i][j] && map[i][j].equals("G")) {
                    bfs("G", i, j);
                    count++;
                }
            }
        }

        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && !map[i][j].equals("B")) {
                    bfs2(i, j);
                    count2++;
                }
            }
        }

        System.out.println(count+" "+count2);
    }
}
