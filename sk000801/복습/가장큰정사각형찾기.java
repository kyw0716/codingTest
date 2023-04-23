package sk000801.복습;

//솔직히 이건 시간 재는게 말이 안됨...
public class 가장큰정사각형찾기 {
    public static int solution(int[][] board) {
        int answer = 0;
        int[][] dp = new int[board.length+1][board[0].length+1];
        for(int i = 1; i <= board.length; i++) {
            for(int j = 1; j <= board[0].length; j++) {
                if(board[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
                }
            }
        }

        for(int i = 1; i <= board.length; i++) {
            for(int j = 1; j <= board[0].length; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer*answer;
    }
    public static void main(String[] args) {
        int[][] board1 = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};	
        int[][] board2 = {{0,0,1,1},{1,1,1,1}};
        System.out.println(solution(board2));
    }   
}
