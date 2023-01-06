package sk000801.백준.브루트포스;
import java.io.*;
import java.util.*;

public class 토마토 {

    static int m;
    static int n;
    static int[][] tom;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q;

    public static int bfs() {
        while(!q.isEmpty()) {
            int[] japyo = q.remove();

            for(int i = 0; i < 4; i++) {
                int nx = japyo[0]+dx[i];
                int ny = japyo[1]+dy[i];
                if(nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    if(tom[nx][ny] == 0) {
                        q.add(new int[]{nx, ny});
                        tom[nx][ny] = tom[japyo[0]][japyo[1]]+1;
                    }
                }
            }
        }

        int result = -100;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(tom[i][j] == 0) return -1;
                result = Math.max(result, tom[i][j]);
            }
        }

        if(result == 1) return 0;
        else return result-1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tom = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                tom[i][j] = Integer.parseInt(st.nextToken());
                if(tom[i][j] == 1) q.add(new int[]{i, j});
            }
        }

        System.out.println(bfs());
    }
}
