package sk000801.백준.bfs연습;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class 나이트의이동 {
    static int l;
    static int[][] map;
    static boolean[][] visited;
    static int[] move;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};
    static Queue<int[]> q;

    public static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] jap = q.poll();

            if(jap[0] == move[0] && jap[1] == move[1]) break;
            
            for(int i = 0; i < 8; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];

                if(nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                if(!visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    map[nx][ny] = map[jap[0]][jap[1]]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int i = 1; i <= tc; i++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];

            int[] cur = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            cur[0] = Integer.parseInt(st.nextToken());
            cur[1] = Integer.parseInt(st.nextToken());

            move = new int[2];
            st = new StringTokenizer(br.readLine());
            move[0] = Integer.parseInt(st.nextToken());
            move[1] = Integer.parseInt(st.nextToken());

            bfs(cur[0], cur[1]);

            System.out.println(map[move[0]][move[1]]);
        }
    }
}
