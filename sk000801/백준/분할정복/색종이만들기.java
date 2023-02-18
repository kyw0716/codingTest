package sk000801.백준.분할정복;
import java.util.*;

//분할정복은 처음이라,,
public class 색종이만들기 {
    static int n;
    static int[][] paper;
    static int[] ans = new int[2];
    public static boolean check(int r, int c, int s) {
        for(int i = r; i < r+s; i++) {
            for(int j = c; j < c+s; j++) {
                if(paper[i][j] != paper[r][c]) return false;
            }
        }
        return true;
    }
    public static void divide(int r, int c, int s) {
        if(check(r, c, s)) {
            if(paper[r][c] == 0) ans[0]++;
            else ans[1]++;
            return;
        }

        int n = s/2;

        divide(r, c, n);
        divide(r, c+n, n);
        divide(r+n, c, n);
        divide(r+n, c+n, n);
    }
    public static void main(String[] srgs) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        paper = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                paper[i][j] = in.nextInt();
            }
        }

        divide(0, 0, n);

        System.out.println(ans[0]+"\n"+ans[1]);
    }
}
