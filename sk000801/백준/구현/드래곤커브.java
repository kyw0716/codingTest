package sk000801.백준.구현;
import java.util.*;

//https://www.acmicpc.net/problem/15685
public class 드래곤커브 {
    static boolean[][] japyo = new boolean[101][101];
    static int[] dx = {0,0,1,1};
    static int[] dy = {0,1,0,1};
    public static List<Integer> getDir(int dir, int gen) {
        List<Integer> dirs = new ArrayList<>();
        dirs.add(dir);

        for(int i = 0; i < gen; i++) {
            for(int j = dirs.size()-1; j >= 0; j--) {
                //시계방향으로의 회전
                int direction = (dirs.get(j)+1)%4;
                dirs.add(direction);
            }
        }

        return dirs;
    }
    public static void curve(int x, int y, List<Integer> dirs) {
        japyo[x][y] = true;
        for(int dir : dirs) {
            switch(dir) {
                case 0:
                    x += 1;
                    break;
                case 1:
                    y -= 1;
                    break;
                case 2:
                    x -= 1;
                    break;
                case 3:
                    y += 1;
                    break;
            }
            japyo[x][y] = true;
        }   
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for(int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int dir = in.nextInt();
            int gen = in.nextInt();

            List<Integer> dirs = getDir(dir, gen);
            curve(x, y, dirs);
        }

        int ans = 0;
        //아래의 for문 범위가 문제였다 왜 100까지 고려하면 안되는걸까
        //어차피 x가 100일때는 탐색이 아예 불가해서 그런가?
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                boolean check = true;
                for(int r = 0; r < 4; r++) {
                    int nx = i+dx[r];
                    int ny = j+dy[r];

                    if(nx<0||nx>100||ny<0||ny>100) continue;
                    if(!japyo[nx][ny]) {check = false; break;}
                }
                if(check) ans++;
            }
        }

        System.out.println(ans);
    }
}
