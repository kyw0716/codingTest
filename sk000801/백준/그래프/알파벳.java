package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

public class 알파벳 {
    static int r, c;
    static String[][] al;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;
    static boolean[] alp = new boolean[26];
    static int answer = 0;

    public static void dfs(int x, int y) {
        alp[(int)al[x][y].charAt(0)-65] = true;
        visited[x][y] = true;
        //if(stack.size()==26) {answer = 26; return;}

        for(int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||nx>=r||ny<0||ny>=c) continue;
            if(!visited[nx][ny] && !alp[(int)al[nx][ny].charAt(0)-65]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
                visited[nx][ny] = false;
                alp[(int)al[nx][ny].charAt(0)-65] = false;
            }
        }

        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(alp[i]) count++;
        }
        answer = Math.max(count, answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        al = new String[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            s = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                al[i][j] = s[j];
            }
        }

        dfs(0, 0);
        
        System.out.println(answer);
    }
}
