package sk000801.백준.그래프;
import java.util.*;

public class 적록색약 {
    static int n;
    static String[][] color;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;

    public static void bfs(String s, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] jap = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(visited[nx][ny] || !color[nx][ny].equals(s)) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void bfs2(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] jap = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(visited[nx][ny] || color[nx][ny].equals("B")) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());
        color = new String[n][n];
        visited = new boolean[n][n];
        int count = 0;
        int count2 = 0;

        for(int i = 0; i < n; i++) {
            String[] s = in.nextLine().split("");
            for(int j = 0; j < n; j++) {
                color[i][j] = s[j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && color[i][j].equals("R")) {
                    bfs("R", i, j);
                    count++;
                } else if(!visited[i][j] && color[i][j].equals("G")) {
                    bfs("G", i, j);
                    count++;
                } else if(!visited[i][j] && color[i][j].equals("B")) {
                    bfs("B", i, j);
                    count++;
                    count2++;
                }
            }
        }

        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && !color[i][j].equals("B")) {
                    bfs2(i, j);
                    count2++;
                }
            }
        }

        System.out.println(count+" "+count2);
    }
}
