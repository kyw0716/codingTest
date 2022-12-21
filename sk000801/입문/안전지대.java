class Solution {
    public int solution(int[][] board) {
        int[][] pad = new int[board.length+2][board[0].length+2];
        int count = 0;
        for(int i = 0; i < pad.length; i++) {
            pad[0][i] = -1;
            pad[i][0] = -1;
            pad[board.length-1][i] = -1;
            pad[i][board.length-1] = -1;
        }
        for(int i = 1; i < pad.length-1; i++) {
            for(int j = 1; j < pad[i].length-1; j++) {
                if(board[i-1][j-1] == 1) {
                    pad[i][j+1] = 1;
                    pad[i][j-1] = 1;
                    pad[i][j] = 1;
                    pad[i+1][j] = 1;
                    pad[i+1][j+1] = 1;
                    pad[i+1][j-1] = 1;
                    pad[i-1][j+1] = 1;
                    pad[i-1][j] = 1;
                    pad[i-1][j-1] = 1;
                }
            }
        }
        for(int i = 1; i < pad.length-1; i++) {
            for(int j = 1; j < pad.length-1; j++) {
                if(pad[i][j] != 1) count++;
            }
        }
        return count;
    }
}