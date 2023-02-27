package sk000801.백준.구현;
import java.io.*;

//https://www.acmicpc.net/problem/14499
//1 234(서위동) 5 6(바닥)
public class 주사위굴리기 {
    static int n, m;
    static int[][] map;
    static int[] dice = new int[7];
    static int x, y;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static StringBuffer sb = new StringBuffer("");
    // 1~4 순서대로 동서남북 
    // 이부분은 직접 이면지에 그려보면서 생각해볼것!
    public static void roll(int num) {
        int ans = dice[3];
        switch(num) {
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = ans;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = ans;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = ans;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = ans;
                break;
        }
        
    }
    public static void move(int num) {
        int nx = x+dx[num-1];
        int ny = y+dy[num-1];;
        if(nx<0||nx>=m||ny<0||ny>=n) return;
        roll(num);
        if(map[ny][nx] == 0) map[ny][nx] = dice[6]; //0이면 바닥면의 수가 복사
        else { //칸에 쓰여있는 수가 주사위의 바닥으로 복사
            dice[6] = map[ny][nx]; 
            map[ny][nx] = 0;
        }
        x = nx;
        y = ny;
        sb.append(dice[3]).append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        y = Integer.parseInt(s[2]);
        x = Integer.parseInt(s[3]);
        int command = Integer.parseInt(s[4]);

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        s = br.readLine().split(" ");
        for(int i = 0; i < command; i++) {
            int num = Integer.parseInt(s[i]);
            move(num);
        }

        System.out.println(sb);
    }
}
