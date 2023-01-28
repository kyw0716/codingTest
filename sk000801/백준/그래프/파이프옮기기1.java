package sk000801.백준.그래프;
import java.util.*;

//가로(가로, 대각선), 세로(가로, 대각선), 대각선(가로, 세로, 대각선)

public class 파이프옮기기1 {
    static int n;
    static int[][] house;
    static int count = 0;

    public static void dfs(int x, int y, int num) {
        //파이프 끝 점 기준
        if(x==n && y==n) {
            count++;
            return;
        }

        switch(num) {
            case 0: //가로
                if(y+1<=n && house[x][y+1] == 0) dfs(x, y+1, 0);
                break;
            case 1: //세로
                if(x+1<=n && house[x+1][y] == 0) dfs(x+1, y, 1);
                break;
            case 2: //대각선?
                if(y+1<=n && house[x][y+1] == 0) dfs(x, y+1, 0);
                if(x+1<=n && house[x+1][y] == 0) dfs(x+1, y, 1);
                break;
        } //공통의 경우
        if(y+1<=n && x+1<=n &&house[x][y+1] == 0 && house[x+1][y] == 0 && house[x+1][y+1] == 0) {
            dfs(x+1, y+1, 2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());
        house = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            String[] s = in.nextLine().split(" ");
            for(int j = 1; j <= n; j++) {
                house[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        dfs(1, 2, 0);

        System.out.println(count);
    }
}
