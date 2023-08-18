package sk000801.백준.그래프;
import java.util.*;

//25분 !! 단순한 bfs 문제인둣
public class 알고스팟 {
    static int m, n;
    static int[][] area;
    static int[] d_x = {-1,0,1,0};
    static int[] d_y = {0,-1,0,1};

    static class Japyo implements Comparable<Japyo> {
        int x, y;
        int count;
        Japyo(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
        @Override
        public int compareTo(Japyo j) {
            return count-j.count;
        }
    }

    public static int bfs(int x, int y) {
        PriorityQueue<Japyo> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[n+1][m+1];
        visited[x][y] = true;
        q.add(new Japyo(x, y, 0));

        while(!q.isEmpty()) {
            Japyo cur = q.poll();

            if(cur.x == n && cur.y == m) return cur.count;

            for(int i = 0; i < 4; i++) {
                int dx = cur.x+ d_x[i];
                int dy = cur.y+ d_y[i];

                if(dx<1||dx>n||dy<1||dy>m) continue;
                if(!visited[dx][dy] && area[dx][dy] == 0) {
                    visited[dx][dy] = true;
                    q.add(new Japyo(dx, dy, cur.count));
                }
                if(!visited[dx][dy] && area[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    q.add(new Japyo(dx, dy, cur.count+1));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        area = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            input = in.nextLine().split("");
            for(int j = 1; j <= m; j++) {
                area[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        System.out.println(bfs(1, 1));
    }
}
