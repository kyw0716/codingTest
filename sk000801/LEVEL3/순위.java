package sk000801.LEVEL3;

class Solution {
    int[][] player;
    public void floyd(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= n; r++) {
                    if(i==j||j==r||i==r) continue;
                    if(player[j][r] > player[j][i]+player[i][r]) {
                        player[j][r] = player[j][i]+player[i][r];
                    }
                }
            }
        }
    }
    public int solution(int n, int[][] results) {
        player = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i!=j) player[i][j] = 10000;
            }
        }
        
        for(int i = 0; i < results.length; i++) {
            player[results[i][0]][results[i][1]] = 1;
        }
        
        floyd(n);
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            boolean linked = true;
            for(int j = 1; j <= n; j++) {
               if(player[i][j] == 10000 && player[j][i] == 10000) {
                   linked = false;
                   break;
               }
            }
            if(linked) answer++;
        }
        
        return answer;
    }
}
