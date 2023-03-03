package sk000801.백준.구현;
import java.io.*;

public class 경사로 {
    static int n, l;
    static int[][] road;
    public static boolean calRow(int row) {
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n-1; i++) {
            int diff = road[row][i]-road[row][i+1];
            if(diff == 0) continue; //같은 경사라면 탐색할 필요x
            if(Math.abs(diff) != 1) return false;
            if(diff == -1) { //다음 계단 = 현재 +1
                for(int j = 0; j < l; j++) {
                    //현재와 그 이전 계단이 모두 같은 높이여야 경사로 설치 가능!
                    //따라서 i-j가 들어가야 함
                    if(i-j < 0 || visited[i-j]) return false;
                    if(road[row][i] != road[row][i-j]) return false;
                    //현재계단-a의 높이에 경사로를 놓았기 때문에 방문처리
                    visited[i-j] = true;
                }
            } 
            if(diff == 1) { //현재 = 다음 계단+1
                for(int j = 1; j <= l; j++) {
                    //다음 계단~끝 까지 모두 같은 높이여야 경사로 설치 가능
                    //따라서 i+j가 들어가야 함
                    if(i+j >= n || visited[i+j]) return false;
                    if(road[row][i]-1 != road[row][i+j]) return false;
                    //다음 계단+a 의 높이에 경사로를 놓았기 때문에 방문처리
                    visited[i+j] = true;
                }
            }
        }
        return true;
    }
    public static boolean calCol(int col) {
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n-1; i++) {
            int diff = road[i][col]-road[i+1][col];
            if(diff == 0) continue; //같은 경사라면 탐색할 필요x
            if(Math.abs(diff) != 1) return false;
            if(diff == -1) { //현재 = 다음+1
                for(int j = 0; j < l; j++) {
                    if(i-j<0 || visited[i-j]) return false;
                    if(road[i-j][col] != road[i][col]) return false;
                    visited[i-j] = true;
                }
            }
            if(diff == 1) { //다음 = 현재+1
                for(int j = 1; j <= l; j++) {
                    if(i+j >= n || visited[i+j]) return false;
                    if(road[i][col]-1 != road[i+j][col]) return false;
                    visited[i+j] = true;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);

        road = new int[n][n];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                road[i][j] =Integer.parseInt(s[j]);
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(calRow(i)) ans++;
            if(calCol(i)) ans++;
        }

        System.out.println(ans);
    }
}
