package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 나이트의이동 {
    static int n;
    static int[][] pan;
    static int finx, finy;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};
    static StringBuffer sb = new StringBuffer("");
    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] top = q.poll();

            if(finx == top[0] && finy == top[1]) return;

            for(int r = 0; r < 8; r++) {
                int nx = top[0]+dx[r];
                int ny = top[1]+dy[r];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(pan[nx][ny] == 0) {
                    pan[nx][ny] = pan[top[0]][top[1]]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            pan = new int[n][n];

            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            finx = Integer.parseInt(s[0]);
            finy = Integer.parseInt(s[1]); 

            if(x == finx && y == finy) {sb.append("0\n"); continue;}

            bfs(x, y);

            sb.append(pan[finx][finy]).append("\n");
        }

        System.out.println(sb);
    }
}
