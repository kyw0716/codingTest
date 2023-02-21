package sk000801.백준.복습;
import java.io.*;

//1. n과 m이 이미 3x3보다 작을 때 -> 그 값들을 바로 판별해서 ans와 같지 않다면 -1
//1-2. 같다면 0
//2. n과 m이 3x3보다 크고 모든 값들에 대해 change 했을 때 -> 같다면 뒤집은 개수 아니면 -1
public class 행렬 {
    static int n, m;
    static int[][] init;
    static int[][] ans;
    public static void change(int x, int y) {
        for(int i = x; i < x+3; i++) {
            for(int j = y; j < y+3; j++) {
                init[i][j] = 1-init[i][j];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        init = new int[n][m];
        ans = new int[n][m];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                init[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                ans[i][j] = Integer.parseInt(s[j]);
            }
        }
        
        if(n<3 || m<3) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(init[i][j] != ans[i][j]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(0);
            return;
        }

        int count = 0;
        for(int i = 0; i < n-2; i++) {
            for(int j = 0; j < m-2; j++) {
                if(init[i][j] != ans[i][j]) {change(i, j); count++;}
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(init[i][j] != ans[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        
        System.out.println(count);
    }
}
