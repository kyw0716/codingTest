package sk000801.LEVEL3;

//38분
//다익스트라로 풀어야 하나 했는데
//플로이드 워셜 통해 모든 경로의 최소 비용을 구해둔 뒤
//s, a, b를 기준으로 잘라 값을 비교해줌
//이때 최솟값을 Integer.MAX_VALUE로 두면 overflow가 발생하기 때문에 이보다는 작되 발생하는 최대 택시 요금보다 크게 잡아야 함..
public class 합승택시요금 {
    int[][] floyd;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        floyd = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i != j) {
                    floyd[i][j] = 20_000_000;
                }
            }
        }
        
        for(int i = 0; i < fares.length; i++) {
            int x = fares[i][0];
            int y = fares[i][1];
            floyd[x][y] = Math.min(fares[i][2], floyd[x][y]);
            floyd[y][x] = Math.min(fares[i][2], floyd[y][x]);
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= n; r++) {
                    if(i == j || j == r || r == i) continue;
                    if(floyd[j][r] > floyd[j][i]+floyd[i][r]) {
                        floyd[j][r] = floyd[j][i]+floyd[i][r];
                    }
                }
            }
        }
        
        int answer = 20_000_000;
        for(int i = 1; i <= n; i++) {
            if(i == s) continue;
            int val = floyd[s][i]+floyd[i][a]+floyd[i][b];
            answer = Math.min(answer, val);
        }
        answer = Math.min(answer, floyd[s][a]+floyd[s][b]);
        return answer;
    }
}