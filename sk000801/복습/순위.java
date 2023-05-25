package sk000801.복습;

public class 순위 {
    public static int solution(int n, int[][] results) {
        int[][] rank = new int[n+1][n+1];
        for(int i = 1; i<= n; i++) {
            for(int j = 1; j<= n; j++) {
                if(i!=j)  rank[i][j] = 10000;
            }
        }
        for(int i = 0; i < results.length; i++) {
            rank[results[i][0]][results[i][1]] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= n; r++) {
                    if(i==j||j==r||i==r) continue;
                    if(rank[j][r] > rank[j][i]+rank[i][r]) rank[j][r] = rank[j][i]+rank[i][r];
                }
            }
        }
        int count = 0;
        for(int i = 1; i <= n; i++) {
            boolean check = true;
            for(int j = 1; j <= n; j++) {
                if(i==j) continue;
                if(rank[i][j] == 10000 && rank[j][i] == 10000) {
                    check = false;
                    break;
                }
            }
            if(check) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};

        System.out.println(solution(n, results));
    }
}
