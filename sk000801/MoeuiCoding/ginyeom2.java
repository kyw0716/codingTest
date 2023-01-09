package sk000801.MoeuiCoding;
import java.io.*;
import java.util.*;

public class ginyeom2 {
    static int r;
    static int c;
    static String[][] map;
    static boolean[][] visited;
    static Stack<String> stack;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;

    public static void dfs(int x, int y) {
        stack.push(map[x][y]);
        if(stack.size()==26) {answer = 26;return;}

        for(int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<=0 || nx > r || ny<=0 || ny > c) continue;
            if(!visited[nx][ny] && !stack.contains(map[nx][ny])) {
                visited[nx][ny] = true;
                dfs(nx, ny);
                visited[nx][ny] = false;
                stack.pop();
            }
        }
        answer = Math.max(answer, stack.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuffer sb = new StringBuffer("");

        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new String[r+1][c+1];
            visited = new boolean[r+1][c+1];
            stack = new Stack<String>();
            answer = 0;

            for(int p = 1; p <= r; p++) {
                String[] s = br.readLine().split("");
                for(int j = 1; j <= c; j++) {
                    map[p][j] = s[j-1];
                }
            }

            dfs(1, 1);

            // sb.append("#"+i+" "+answer);
            // sb.append("\n");
            System.out.println("#"+i+" "+answer);
        } 

        //System.out.println(sb);
    }   
}
