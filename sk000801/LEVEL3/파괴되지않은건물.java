package sk000801.LEVEL3;

// 누적합 알고리즘 힌트 -> 30분
public class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int[][] prefix = new int[board.length][board[0].length];
        for(int i  = 0; i < skill.length; i++) {
            int val = skill[i][0] == 1 ? (-1)*skill[i][5] : skill[i][5];
            int r1 = skill[i][1]; int c1 = skill[i][2];
            int r2 = skill[i][3]; int c2 = skill[i][4];
            
            prefix[r1][c1] += val;
            if(r2+1 < board.length) prefix[r2+1][c1] +=(-1)*val;
            if(c2+1 < board[0].length) prefix[r1][c2+1] += (-1)*val;
            if(r2+1 < board.length && c2+1 < board[0].length) prefix[r2+1][c2+1] += val;
        }
        
        for(int i = 0; i < prefix.length; i++) {
            for(int j = 1; j < prefix[i].length; j++) {
                prefix[i][j] += prefix[i][j-1];
            }
        }
        
        for(int i = 0; i < prefix[0].length; i++) {
            for(int j = 1; j < prefix.length; j++) {
                prefix[j][i] += prefix[j-1][i];
            }
        }
        
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(prefix[i][j]+board[i][j] >= 1) answer++;
            }
        }
        
        return answer;
    }
}
