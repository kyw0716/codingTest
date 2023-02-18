package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

public class 여행가자 {
    static int n, m;
    static int[][] floyd;
    static List<List<Integer>> list = new ArrayList<>();
    public static void floyd() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= n; r++) {
                    if(i==j||j==r||i==r) continue;
                    if(floyd[j][r] > floyd[j][i]+floyd[i][r]) {
                        floyd[j][r] = floyd[j][i]+floyd[i][r];
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        floyd = new int[n+1][n+1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i!=j) floyd[i][j] = 10000;
            }
        }

        for(int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 1; j <= n; j++) {
                int a = Integer.parseInt(s[j-1]);
                if(a == 1) {floyd[i][j] = floyd[j][i] = 1;}
            }
        }

        floyd();

        String[] s = br.readLine().split(" ");
        int[] link = new int[m];
        for(int i = 0; i < m; i++) {
            link[i] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i < m-1; i++) {
            if(floyd[link[i]][link[i+1]] == 10000) {System.out.println("NO"); return;}
        }

        System.out.println("YES");
    }
}

