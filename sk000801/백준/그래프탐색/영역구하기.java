package sk000801.백준.그래프탐색;
import java.io.*;
import java.util.*;

public class 영역구하기 {
    static int m;
    static int n;
    static int k;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int gaesu = 0;
    static List<Integer> neol = new ArrayList<>();

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            gaesu++;
            int[] jap = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];

                if(nx<=0 || nx>n || ny<=0 || ny>m) continue;
                if(visited[nx][ny] || area[nx][ny] == 1) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        area = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        gaesu = 0;
        
        for(int i = 1; i <= k; i++) {
            String[] s = br.readLine().split(" ");
            for(int x = Integer.parseInt(s[0])+1; x <= Integer.parseInt(s[2]); x++) {
                for(int y = Integer.parseInt(s[1])+1; y <= Integer.parseInt(s[3]); y++) {
                    area[x][y] = 1;
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(!visited[i][j] && area[i][j] == 0) {
                    gaesu = 0;
                    bfs(i, j);
                    neol.add(gaesu);
                }
            }
        }

        System.out.println(neol.size());
        Collections.sort(neol);
        for(int i = 0; i < neol.size(); i++) {
            System.out.print(neol.get(i)+ " ");
        }
    }
}
