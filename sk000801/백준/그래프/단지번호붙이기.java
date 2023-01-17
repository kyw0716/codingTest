package sk000801.백준.그래프;
import java.util.*;

public class 단지번호붙이기 {
    static List<Integer> su = new ArrayList<>();
    static int n;
    static boolean[][] visited;
    static int[][] dan;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void bfs(int x, int y) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] jap = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny >= n) continue;
                if(dan[nx][ny] == 0 || visited[nx][ny]) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }

            count++;
        }

        su.add(count);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());
        dan = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] s = in.nextLine().split("");
            for(int j = 0; j < n; j++) {
                dan[i][j] = Integer.parseInt(s[j]);
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && dan[i][j] == 1) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        Collections.sort(su);

        System.out.println(count);
        for(int i = 0; i < su.size(); i++) {
            System.out.println(su.get(i));
        }

    }
}
