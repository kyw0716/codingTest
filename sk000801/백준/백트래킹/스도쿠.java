package sk000801.백준.백트래킹;
import java.util.*;

public class 스도쿠 {
    static int[][] sdoku = new int[9][9];
    static boolean[][] hasNum = new boolean[9][9];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    //체크 여부는 행, 열 줄에, 그리고 9등분된 칸에 겹치는 수가 있는지 확인!
    //없다면 빈 칸에 채워넣을 수 있는 수
    public static boolean check(int i, int j, int num) {
        for(int r = 0; r < 9; r++) {
            if(sdoku[r][j] == num) return false;
            if(sdoku[i][r] == num) return false;
        }

        //9등분 했을 때
        int row = (i/3)*3;
        int col = (j/3)*3;
        for(int x = row; x < row+3; x++) {
            for(int y = col; y < col+3; y++) {
                if(sdoku[x][y] == num) return false;
            }
        }

        return true;
    }

    public static void dfs(int i, int j) {
        if(j == 9) { //끝 열로 갔을 때는 아래 행으로 옮기기
            dfs(i+1, 0);
            return;
        }

        if(i == 9) { //끝 행으로 갔을 때는 다 돌았으니까 출력!
            for(int x = 0; x < 9; x++) {
                for(int y = 0; y < 9; y++) {
                    System.out.print(sdoku[x][y]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(sdoku[i][j] == 0) {
            for(int r = 1; r <= 9; r++) {
                if(check(i, j, r)) {
                    sdoku[i][j] = r;
                    dfs(i, j+1);
                }
            }
            sdoku[i][j] = 0;
            return;
        }
        dfs(i, j+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sdoku[i][j] = in.nextInt();
            }
        }

        dfs(0, 0);
    }
}
