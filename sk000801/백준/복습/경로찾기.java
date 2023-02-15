package sk000801.백준.복습;
import java.io.*;

public class 경로찾기 {
    static int n;
    static int[][] graph;
    public static void floyd() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int r = 0; r < n; r++) {
                    if(graph[j][r] > graph[j][i]+graph[i][r]) {
                        graph[j][r] = graph[j][i]+graph[i][r];
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
                if(graph[i][j] == 0) graph[i][j] = 9876543;
            }
        }

        floyd();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == 9876543) System.out.print("0 ");
                else System.out.print("1 ");
            }
            System.out.println();
        }
    }   
}
