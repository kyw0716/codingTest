package sk000801.백준.그래프;
import java.util.*;

//처음에 무조건 최소값인데에서 시작해야 많은 칸을 이동할 수 있다는 실수를..
//35분
//그리고 dp를 활용해야 하는 문제다(val배열이 dp배열임)
public class 욕심쟁이판다 {
    static int n;
    static int[][] area;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] val;

    public static int dfs(int x, int y) {
        if(val[x][y] != 0) return val[x][y];

       val[x][y] = 1;

       for(int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||nx>=n||ny<0||ny>=n) continue;
            if(area[x][y] < area[nx][ny]) {
                //상하좌우로 이동했을 경우 가장 많이 이동할 수 있는 개수 찾기
                val[x][y] = Math.max(val[x][y], dfs(nx, ny)+1);
                dfs(nx, ny);
            }
       }

       return val[x][y];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        area = new int[n][n];
        val = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                area[i][j] = in.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int a = dfs(i, j);
                if(max < a) max = a;
            }
        }

        System.out.println(max);
    }
}
