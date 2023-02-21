package sk000801.백준.분할정복;
import java.io.*;

public class 쿼드트리 {
    static int n;
    static int[][] media;
    static StringBuffer sb = new StringBuffer("");
    public static int check(int r, int c, int s) {
        int c1 = 0; int c2 = 0;
        for(int i = r; i < r+s; i++) {
            for(int j = c; j < c+s; j++) {
                if(media[i][j] == 1) c1++;
                else c2++;
            }
        }
        if(c1==s*s) return 1;
        if(c2==s*s) return 0;
        else return -1;
    }
    public static void divide(int r, int c, int s) {
        int res = check(r,c,s);
        if(res >= 0) {sb.append(res); return;}

        sb.append("(");
        divide(r, c, s/2);
        divide(r, c+s/2, s/2);
        divide(r+s/2, c, s/2);
        divide(r+s/2, c+s/2, s/2);
        sb.append(")");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        media = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                media[i][j] = Integer.parseInt(s[j]);
            }
        }

        divide(0, 0, n);

        System.out.println(sb);
    }   
}
