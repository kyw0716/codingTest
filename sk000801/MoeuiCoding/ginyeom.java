package sk000801.MoeuiCoding;
import java.io.*;
import java.util.*;

public class ginyeom {
    static int r;
    static int c;
    static String[][] map;
    static boolean[][] visited;
    static List<String> present;
    static Set<String> set;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;

    public static void dfs(int result, int x, int y) {
        set = new HashSet<>(present);
        present = new ArrayList<String>(set);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <= 0 || nx > r || ny <= 0 || ny > c) continue;
            if(!present.contains(map[nx][ny]) && !visited[nx][ny]) {
                present.add(map[nx][ny]);
                visited[nx][ny] = true;
                dfs(result+1,nx, ny);
                visited[nx][ny] = false;
            }
        }
        answer = Math.max(answer, result);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");

        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new String[r+1][c+1];
            visited = new boolean[r+1][c+1];

            for(int p = 1; p <= r; p++) {
                String[] s = br.readLine().split("");
                for(int j = 1; j <= c; j++) {
                    map[p][j] = s[j-1];
                }
            }

            present = new ArrayList<String>();
            visited[1][1] = true;
            present.add(map[1][1]);
            answer = 0;
            dfs(0,1,1);

            //present.size()
            sb.append("#"+i+" " + answer);
            sb.append("\n");
        }

        System.out.println(sb);
    }
    
}
