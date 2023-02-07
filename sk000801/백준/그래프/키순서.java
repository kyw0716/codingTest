package sk000801.백준.그래프;
import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2458
//모든 노드로 이동할 수 있는지 여부를 판별 -> 플로이드 워셜 알고리즘,,
public class 키순서 {
    static int n, m;
    static int[][] floyd;
    public static void check() {
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        floyd = new int[n+1][n+1];
        int ans = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i != j) floyd[i][j] = 9876543;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            floyd[a][b] = 1;
        }

        check();

        for(int i = 1; i <= n; i++) {
            boolean linked = true;
            for(int j = 1; j <= n; j++) {
                //모든 학생과의 비교가 가능할 때
                if(floyd[i][j] == 9876543 && floyd[j][i] == 9876543){
                    linked = false;
                    break;
                } 
            }
            if(linked) ans++;
        }

        System.out.println(ans);
    }
}
