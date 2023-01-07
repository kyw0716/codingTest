package sk000801.백준.브루트포스;
import java.util.*;
import java.io.*;

public class 친구 {

    //DP알고리즘
    //플로이드 와샬 알고리즘
    static int[][] friend;
    static int n;

    public static void floyd() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int r = 0; r < n; r++) {
                    if(i==j || j == r || i == r) continue;
                    else if(friend[j][r] > friend[j][i] + friend[i][r]) {
                        friend[j][r] = friend[j][i] + friend[i][r];
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        friend = new int[n][n];
        int max = 0;

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                char c = s.charAt(j);

                if(c == 'Y') friend[i][j] = 1;
                else if (i != j) friend[i][j] = 987654321;
            }
        }

        floyd();

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(i==j) continue;
                else if(friend[i][j] <= 2) count++;
            }
            max = Math.max(count, max);
        }

        System.out.println(max);
    }
}
