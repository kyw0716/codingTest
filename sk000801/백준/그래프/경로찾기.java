package sk000801.백준.그래프;
import java.io.*;

public class 경로찾기 {
    static int n;
    static int[][] line;

    public static void ployd() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int r = 0; r < n; r++) {
                    if(line[j][r] > line[j][i]+line[i][r]) line[j][r] = line[j][i]+line[i][r];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        line = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                line[i][j] = Integer.parseInt(s[j]);
                if(line[i][j] == 0) line[i][j] = 98765432;
            }
        }

        ployd();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(line[i][j] == 98765432) System.out.print("0 ");
                else System.out.print("1 ");
            }
            System.out.println();
        }
    }
}
