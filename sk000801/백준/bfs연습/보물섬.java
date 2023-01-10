package sk000801.백준.bfs연습;
import java.util.*;

public class 보물섬 {
    static int n;
    static int m;
    static String[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();
    static int max = 0;
    public static void bfs(int i, int j) {
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                visited[x][y] = -1;
            }
        }
        visited[i][j] = 0;
        q.add(new int[] {i, j});

        while(!q.isEmpty()) {
            int[] jap = q.poll();

            for(int p = 0; p < 4; p++) {
                int nx = jap[0]+dx[p];
                int ny = jap[1]+dy[p];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny] == -1 && map[nx][ny].equals("L")) {
                    visited[nx][ny] = visited[jap[0]][jap[1]] +1;
                    q.add(new int[]{nx, ny});
                    max = Math.max(max, visited[nx][ny]);
                }
            } 
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] s1 = in.nextLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        map = new String[n][m];
        
        for(int i = 0; i < n; i++) {
            String[] s = in.nextLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = s[j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j].equals("L")) {
                    visited = new int[n][m];
                    q = new LinkedList<>();
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(max);
   } 
}

//처음에는 모든 방문 값을 -1(가장 작은 값)로 초기화 하여 현재 위치와 가장 먼 육지를 계산하고 비교
