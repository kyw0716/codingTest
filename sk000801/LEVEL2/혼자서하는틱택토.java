package sk000801.LEVEL2;

//https://school.programmers.co.kr/learn/courses/30/lessons/160585
//42분
// check함수는 열, 행, 대각선 별로 승리 조건을 만족하는지 여부 판별하는 함수
// ** 말이 안되는 경우인지부터 판별해야함
// 1. O와 X의 개수 차이 2개 이상 날 때
// 2. O가 3개 이상 나올 때
// 3. X가 3개 이상 나올 때
// 4. O와 X 둘 모두 승리 조건을 만족했을 때

// 승자 정해진 여부 or O와 X의 개수 가 관건
class 혼자서하는틱택토 {
    public boolean check(String[] board, char c) {
        for(int i = 0; i < 3; i++) { //열 
            boolean flag = true;
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) != c) flag = false;
            }
            if(flag) return true;
        }
        
        for(int i = 0; i < 3; i++) { //행
            boolean flag = true;
            for(int j = 0; j < 3; j++) {
                if(board[j].charAt(i) != c) flag = false;
            }
            if(flag) return true;
        }
        
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;
        
        return false;
    }
    public int solution(String[] board) {
        int countO = 0;
        int countX = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'O') {
                    countO++;
                }
                else if(board[i].charAt(j) == 'X') {
                    countX++;
                }
            }
        }
        if(countO-countX == 0 || countO-countX == 1) {
            if(countO >= 3) {
                if(check(board, 'O')) {
                    if(check(board, 'X')) return 0;
                    else if(countO-countX == 1) return 1;
                    else return 0;
                }
            }
            if(countX >= 3) {
                if(check(board, 'X')) {
                    if(countO-countX == 0) return 1;
                    else return 0;
                }
            }
        } else return 0;
        
        return 1;
    }
}
