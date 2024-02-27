package sk000801.백준.구현;
import java.util.*;

// n최대 20
// 1. 1~r~x+d1 , 1~c~y
// 2. 1~r~x+d2 , y~c~N
// 3. x+d1~r~N , 1~c~y-d1+d2
// 4. x+d2~r~N , y-d1+d2~c~N

// 거의 1시간인디...

public class 백준17779 {
    static int n;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static int entireNum = 0;

    public static int calArea(int x1, int x2, int y1, int y2, boolean[][] isBoundary) {
        int res = 0;

        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(isBoundary[i][j]) break;
                res += map[i][j];
            }
        }

        return res;
    }

    public static int cal(int x, int y, int d1, int d2) {
        int[] val = new int[5];
        boolean[][] isBoundary = new boolean[n][n];

        for(int i = 0; i <= d1; i++) {
            isBoundary[x+i][y-i] = true;
            isBoundary[x+d2+i][y+d2-i] = true;
        }

        for(int i = 0; i <= d2; i++) {
            isBoundary[x+i][y+i] = true;
            isBoundary[x+d1+i][y-d1+i] = true;
        }

        val[0] = calArea(0, x+d1-1, 0, y, isBoundary);
        val[1] = calArea(0, x+d2, y+1, n-1, isBoundary);
        val[2] = calArea(x+d1, n-1, 0, y-d1+d2-1, isBoundary);
        val[3] = calArea(x+d2+1, n-1, y-d1+d2, n-1, isBoundary);
        val[4] = entireNum-val[0]-val[1]-val[2]-val[3];

        Arrays.sort(val);
        
        return val[4]-val[0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
                entireNum += map[i][j];
            }
        }

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                for(int d1 = 1; d1 < n; d1++) {
                    for(int d2 = 1; d2 < n; d2++) {
                        if(x+d1+d2 >= n) continue;
                        if(y-d1 < 0 || y+d2 >= n) continue;

                        int val = cal(x, y, d1, d2);
                        min = Math.min(val, min);
                    }
                }
            }
        }

        System.out.println(min);
    }   
}
