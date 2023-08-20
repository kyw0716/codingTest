package sk000801.백준.그래프;
import java.util.*;

// 거의 2시간...ㅠㅠ
// 치즈 없는 칸 0, 치즈 있는 칸 1
// 치즈가 있는 부분의 테두리 부분이 녹는데 이걸 어떠케 찾을가,,
public class 치즈 {
    static int n,m;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;
    static int cheese = 0;
    static List<Integer> left = new ArrayList<>();

    public static int bfs() {
       int count = 0;

       while(true) {
            boolean[][] visited = new boolean[n][m];
            visited[0][0] = true;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});

            while(!q.isEmpty()) {
                int[] cur = q.poll();

                for(int i = 0; i < 4; i++) {
                    int nx = cur[0]+dx[i];
                    int ny = cur[1]+dy[i];

                    if(nx<0||nx>=n||ny<0||ny>=m) continue;
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if(map[nx][ny] == 0) {
                            q.add(new int[]{nx, ny});
                        } else {
                            cheese--;
                            map[nx][ny] = 0;
                        }
                    }
                }
            }

            count++;
            left.add(cheese);
            if(cheese == 0) break;
       }

       return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        map = new int[n][m];
        int firstCheese = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
                if(map[i][j] == 1) cheese++;
            }
        }

        firstCheese = cheese;

        int time = bfs();
        System.out.println(time);
        if(time == 1) System.out.println(firstCheese);
        else System.out.println(left.get(left.size()-2));
    }
}
