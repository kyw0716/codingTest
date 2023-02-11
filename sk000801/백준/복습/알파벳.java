package sk000801.백준.복습;
import java.util.*;

public class 알파벳 {
    static boolean[] alphabet = new boolean[26];
    static boolean[][] visited;
    static int a, b;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Character[][] map;
    static int max = 0;
    public static void dfs(int i, int j) {
        visited[i][j] = true;
        alphabet[(int)map[i][j]-65] = true;

        for(int r = 0; r < 4; r++) {
            int nx = i+dx[r];
            int ny = j+dy[r];

            if(nx<0||nx>=a||ny<0||ny>=b) continue;
            if(!visited[nx][ny] && !alphabet[(int)map[nx][ny]-65]) {
                //visited[nx][ny] = true;
                dfs(nx, ny);
                visited[nx][ny] = false;
                alphabet[(int)map[nx][ny]-65] = false;
            }
        }

        int count = 0;
        for(int r = 0; r < 26; r++) {
            if(alphabet[r]) count++;
        }

        max = Math.max(count, max);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] s = in.nextLine().split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        visited = new boolean[a][b];
        map = new Character[a][b];

        for(int i = 0; i < a; i++) {
            s = in.nextLine().split("");
            for(int j = 0; j < b; j++) {
                map[i][j] = s[j].charAt(0);
            }
        }

        dfs(0,0);

        System.out.println(max);
    }
}
