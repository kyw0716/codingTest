package sk000801.백준.복습;
import java.io.*;
import java.util.*;

//이문제도 그렇고 앞서 푼 문제도 그렇고
//브루트포스의 그래프 탐색은 주어진 배열 안에 값을 더해서 
//원하는 정답을 도출하는게 풀이 방식인듯
public class 토마토 {
    static int n, m;
    static int[][] tom;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Queue<int[]> q = new LinkedList<>();
    public static void bfs() {
        while(!q.isEmpty()) {
            int[] top = q.poll();

            for(int r = 0; r < 4; r++) {
                int nx = top[0]+dx[r];
                int ny = top[1]+dy[r];

                if(nx<0||nx>=m||ny<0||ny>=n) continue;
                if(tom[nx][ny] == 0) {
                    tom[nx][ny] = tom[top[0]][top[1]]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        tom = new int[m][n];

        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                tom[i][j] = Integer.parseInt(s[j]);
                if(tom[i][j] == 1) q.add(new int[]{i, j});
            }
        }

        bfs();

        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(tom[i][j] == 0) {System.out.println(-1); return;}
                max = Math.max(tom[i][j], max);
            }
        }

        System.out.println(max-1);
    }
}
