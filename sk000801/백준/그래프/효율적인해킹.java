package sk000801.백준.그래프;
import java.io.*;

//얘도 플로이드 워셜(?) 쓰면 되지 않울까...
//단방향 그래프 탐색 문제라 bfs를 써야 하나봄 ㅠㅠㅠ
//왜 메모리 초과.......

public class 효율적인해킹 {
    static int n;
    static int[][] comp;
    public static void ployd() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int r = 0; r < n; r++) {
                    if(i==j || j==r || i==r) continue;
                    if(comp[j][r] > comp[j][i]+comp[i][r]) {
                        comp[j][r] = comp[j][i]+comp[i][r];
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        comp = new int[10000][10000];
        int max = Integer.MIN_VALUE;
        int[] res = new int[10000];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i==j) comp[i][j] = 0;
                else comp[i][j] = comp[j][i] = 50000;
            }
        }

        for(int i = 1; i <= m; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0])-1;
            int y = Integer.parseInt(s[1])-1;
            comp[y][x] = 1;
        }

        ployd();

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(comp[i][j] < 50000) count++;
            }
            res[i] = count;
            max = Math.max(max, count);
        }

        for(int i = 0; i < n; i++) {
            if(max == res[i]) {
                System.out.print((i+1)+" ");
            }
        }
    }
}


// n은 5개
// 3이 1, 2를 신뢰
// 4가 3을 신뢰
// 5가 3을 신뢰 
// 1 -> 1,3,4,5
// 2 -> 2,3,4,5
// 3 -> 4,5
// 4 -> x
// 5 -> x
// B 해킹 -> A 해킹 