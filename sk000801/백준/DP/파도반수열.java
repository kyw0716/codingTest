package sk000801.백준.DP;
import java.io.*;

public class 파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] pado = new long[101];
        pado[1] = 1;
        pado[2] = 1;
        pado[3] = 1;

        for(int i = 4; i <= 100; i++) {
            pado[i] = pado[i-3]+pado[i-2];
        }

        for(int i = 1; i <= n; i++) {
            int p = Integer.parseInt(br.readLine());
            System.out.println(pado[p]);
        }
    }
}
