package sk000801.복습;
import java.util.*;

//17분
public class 컬러링북 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int count = 0;
    static List<Integer> list = new ArrayList<>();
    static boolean[][] visited;
    public static int bfs(int[][] picture, boolean[][] visited, int val, int x, int y) {
        Queue<int[]>  q = new LinkedList<>();
        q.add(new int[]{x, y});
        int count = 1;

        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = top[0]+dx[i];
                int ny = top[1]+dy[i];

                if(nx<0||nx>=picture.length||ny<0||ny>=picture[0].length||visited[nx][ny]) continue;
                if(picture[nx][ny] == val && picture[nx][ny] != 0) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        return count;
    }
    public static int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[0].length; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    visited[i][j] = true;
                    int val = picture[i][j];
                    list.add(bfs(picture, visited, val, i, j));
                }
            }
        }
        list.sort(Collections.reverseOrder());

        return new int[]{list.size(), list.get(0)};
    }
    public static void main(String[] args) {
        int m1 = 6; int n1 = 4; 
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] res = solution(m1, n1, picture);
        System.out.println(res[0]+" "+res[1]);
    }
}
