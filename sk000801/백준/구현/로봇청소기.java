package sk000801.백준.구현;
import java.io.*;

//https://www.acmicpc.net/problem/14503
//북 동 남 서
public class 로봇청소기 {
    static int n, m;
    static int[][] map;
    static int dir;
    static int count = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void move(int x, int y) {
        if(map[x][y] == 0) {
             map[x][y] = 2; count++;
        }
       
        boolean clean = false;
        for(int i = 0; i < 4; i++) {
            if(dir == 0) dir = 3; //미리 방향을 바꿔가면서 확인
            else dir -= 1;
            int nx2 = x+dx[dir];
            int ny2 = y+dy[dir];

            if(nx2<0||nx2>=n||ny2<0||ny2>=m) continue;
            if(map[nx2][ny2] == 0) {
                clean = true;

                int nx = x, ny = y;
                switch(dir) {
                    case 0:
                        nx -= 1;
                        break;
                    case 1:
                        ny += 1;
                        break;
                    case 2:
                        nx += 1;
                        break;
                    case 3:
                        ny -= 1;
                        break;
                }
                if(map[nx][ny] == 0) {move(nx, ny); break;}
            }
        }
        
        if(!clean) {
            int nx = x, ny = y;
            switch(dir) {
                    case 0:
                        nx += 1;
                        break;
                    case 1:
                        ny -= 1;
                        break;
                    case 2:
                        nx -= 1;
                        break;
                    case 3:
                        ny += 1;
                        break;
            }
            if(map[nx][ny] != 1) move(nx, ny);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];

        s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        dir = Integer.parseInt(s[2]);

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        move(x, y);

        System.out.println(count);
    }
}
