package sk000801.백준.구현;
import java.util.*;

//재귀(그냥 코드 작성하려다가 ...)로 양 옆 톱니바퀴의 방향까지 체크해야됨
//https://www.acmicpc.net/problem/14891
public class 톱니바퀴 {
    static int[][] wheel = new int[4][8];
    public static void clock(int num) {
        int[] newwheel = new int[8];
        for(int i = 0; i < 8; i++) {
            if(i==0) newwheel[i] = wheel[num][7];
            else newwheel[i] = wheel[num][i-1];
        }
        wheel[num] = newwheel;
    }
    public static void nonclock(int num) {
        int[] newwheel = new int[8];
        for(int i = 0; i < 8; i++) {
            if(i==7) newwheel[i] = wheel[num][0];
            else newwheel[i] = wheel[num][i+1];
        }
        wheel[num] = newwheel;
    }
    public static void left(int num, int dir) {
        if(num<0) return;
        if(wheel[num][2] == wheel[num+1][6]) return;
        left(num-1, -dir);
        if(dir==1) clock(num);
        else nonclock(num);
    }
    public static void right(int num, int dir) {
        if(num>3) return;
        if(wheel[num][6] == wheel[num-1][2]) return;
        right(num+1, -dir);
        if(dir==1) clock(num);
        else nonclock(num);
    }
    public static void dirmove(int num, int dir) {
        left(num-1, -dir);
        right(num+1, -dir);
        if(dir==1) clock(num);
        else nonclock(num);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < 4; i++) {
            String[] s = in.nextLine().split("");
            for(int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(s[j]);
            }
        }

        int tc = Integer.parseInt(in.nextLine());

        for(int i = 0; i < tc; i++) {
            String[] s = in.nextLine().split(" ");
            int wheelnum = Integer.parseInt(s[0])-1;
            int dir = Integer.parseInt(s[1]);

            dirmove(wheelnum, dir);
        }

        int ans = 0;
        if(wheel[0][0] == 1) ans += 1;
        if(wheel[1][0] == 1) ans += 2;
        if(wheel[2][0] == 1) ans += 4;
        if(wheel[3][0] == 1) ans += 8;

        System.out.println(ans);
    }
}
