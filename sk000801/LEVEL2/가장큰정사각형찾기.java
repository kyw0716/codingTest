package sk000801.LEVEL2;

//dp라는 힌트로 접근해서 8분...!
//현재 인덱스의 값이 1일때 (정사각형의 우측 꼭짓점 값 기준)
//정사각형을 이루는 나머지 3 인덱스의 값 중 최솟값+1이 현재 인덱스값
//(한곳이라도 1이 아니라면 정사각형을 이룰 수 없으므로)
class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] map = new int[board.length+1][board[0].length+1];
        for(int i = 1; i <= board.length; i++) {
            for(int j = 1; j <= board[0].length; j++) {
                if(board[i-1][j-1] == 1) {
                    int min = Math.min(Math.min(map[i-1][j], map[i][j-1]), map[i-1][j-1]);
                    map[i][j] = min+1;
                    
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }
        return answer*answer;
    }
}