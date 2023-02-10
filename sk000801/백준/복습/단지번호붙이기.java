package sk000801.백준.복습;
import java.util.*;

public class 단지번호붙이기 {
    static int n;
    static int[][] danji;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static List<Integer> list = new ArrayList<>();

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int num = 0;
        visited[i][j] = true;
        q.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int r = 0; r < 4; r++) {
                int nx = top[0]+dx[r];
                int ny = top[1]+dy[r];

                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(danji[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }

            num++;
        }

        list.add(num);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        danji = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                danji[i][j] = in.nextInt();
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(danji[i][j] == 1 && !visited[i][j]) {bfs(i, j); count++;}
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list);
        }
    }
}
