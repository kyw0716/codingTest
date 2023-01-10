package sk000801.백준.그래프탐색;

import java.io.*;
import java.util.*;

public class 안전영역 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int answer = 1;
    static int n;
    static int[][] rain;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] jap = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];

                if(nx <= 0 || nx > n || ny <= 0 || ny > n) continue;
                if(visited[nx][ny] || rain[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        for(int i = min; i <= max; i++) {
            rain = new int[n+1][n+1];
            visited = new boolean[n+1][n+1];
            int count = 0;
            for(int x = 1; x <= n; x++) {
                for(int y = 1; y <= n; y++) {
                    if(map[x][y] <= i) rain[x][y] = 1;
                }
            }
           for(int z = 1; z <= n; z++) {
                for(int r = 1; r <= n; r++) {
                    if(!visited[z][r] && rain[z][r] == 0) {bfs(z, r); count++;}
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
