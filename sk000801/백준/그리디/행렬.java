package sk000801.백준.그리디;
import java.io.*;

public class 행렬 {
    static int[][] fir;
    static int[][] res;

    public static void dwigip(int x, int y) {
        for(int i = x; i < x+3; i++) {
            for(int j = y; j < y+3; j++) {
                fir[i][j] = fir[i][j] == 0 ? 1 : 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        fir = new int[n][m];
        res = new int[n][m];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                fir[i][j] = Integer.parseInt(s[j]);
            } 
        }

        for(int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                res[i][j] = Integer.parseInt(s[j]);
            } 
        }

        
        if(n < 3 || m < 3) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(res[i][j] != fir[i][j]) {
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
                if(fir[i][j] != res[i][j]) {
                    dwigip(i, j);
                    count++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(fir[i][j] != res[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }
}
