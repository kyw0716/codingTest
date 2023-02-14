package sk000801.백준.복습;
import java.io.*;
import java.util.*;


// 1. 지도에서 빈칸(=0)인 영역 중 3군데를 dfs를 통해 벽(=1)을 세운다.
// 2. 3개를 다 채웠다면, bfs 함수 안에서 큐에 바이러스 영역을 모두 담는다.
// 3. 벽을 어디에 세웠는지에 따라 지도가 달라지므로 새로운 지도 배열을 만든다.
// 4. 큐가 비워질 때까지 바이러스 주변 영역에 바이러스를 퍼뜨린다.
// 5. 이후 안전 영역(=0인 부분)을 탐색하면서 최댓값을 찾는다
// 실로 dfs와 bfs를 모두 활용하는 아름다운 문제,,
public class 연구소 {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int max = 0;
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        int[][] map2 = new int[n][m];
        for(int i = 0; i < n; i++) {
            map2[i] = map[i].clone();
        }

        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = top[0]+dx[i];
                int ny = top[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if(map2[nx][ny] == 0) {
                    map2[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int area = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map2[i][j] == 0) area++;
            }
        }

        max = Math.max(area, max);
    }

    public static void dfs(int depth) {
        if(depth == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(0);

        System.out.println(max);
    }
}
