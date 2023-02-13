package sk000801.백준.복습;
import java.io.*;
import java.util.*;

//정답값 하나만 출력하면 되므로 System.exit(0)을 해줘야 함 
//안그러면 계속 반복되고 난리남
public class 스도쿠 {
    static int[][] sdk = new int[9][9];
    public static boolean check(int i, int j, int num) {
        for(int x = 0; x < 9; x++) {
            if(sdk[x][j] == num) return false;
            if(sdk[i][x] == num) return false;
        }

        int r = (i/3)*3;
        int c = (j/3)*3;

        for(int x = r; x < r+3; x++) {
            for(int y = c; y < c+3; y++) {
                if(sdk[x][y] == num) return false;
            }
        }

        return true;
    }
    public static void dfs(int i, int j) {
        if(j==9) {
            dfs(i+1, 0);
        }

        if(i==9) {
            for(int x = 0; x < 9; x++) {
                for(int y = 0; y < 9; y++) {
                    System.out.print(sdk[x][y]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(sdk[i][j] == 0) {
            for(int z = 1; z <= 9; z++) {
                if(check(i, j, z)) {
                    sdk[i][j] = z;
                    dfs(i, j+1);
                }
            }
            sdk[i][j] = 0;
            return;
        }
        dfs(i, j+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                sdk[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
    }
}
