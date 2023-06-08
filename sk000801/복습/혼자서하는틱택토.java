package sk000801.복습;

//22분
public class 혼자서하는틱택토 {
    //가로, 세로, 대각선으로 3개가 같은 표시가 만들어지면 그 표시를 만든 사람이 승리
    public static boolean check(String[] board, char c) {
        //열의 문자들이 모두 같을 때
        for(int i = 0; i < 3; i++) {
            boolean check = true;
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) != c) check = false;
            }
            if(check) return true;

        }
        
        //행의 문자들이 모두 같을 때
        for(int i = 0; i < 3; i++) {
            boolean check = true;
            for(int j = 0; j < 3; j++) {
                if(board[j].charAt(i) != c) check = false;
            }
            if(check) return true;
        }

        //왼쪽 위, 오른쪽 위에서 내려오는 문자가 같을 때 (대각선 일치)
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;

        return false;
    }
    public static int solution(String[] board) {
        // O와 X의 개수 차이가 2 이상일 때
        // O와 X 모두 승리한 경우
        int countO = 0;
        int countX = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'O') countO++;
                else if(board[i].charAt(j) == 'X') countX++;
            }
        }

        //아무 생각 없이 2 이상일 때의 경우를 if, 나머지를 else로 뒀는데
        //생각해보니 countX가 더 큰 경우는 없기 때문에 혹여나 countO-countX가 음수일 경우도 생각해
        //countO-countX가 0 or 1일때만 경우를 처리하고 나머지 경우는 0을 반환하는 것이 좋을 것 같다
        if(countO-countX == 0 || countO-countX == 1) {
            if(countO >= 3) {
                if(check(board, 'O')) {
                    if(check(board, 'X')) return 0;
                    else if(countO-countX == 1) return 1;
                    else return 0;
                }
            } else if(countX >= 3) {
                if(check(board, 'X')) {
                    if(countO-countX == 0) return 1;
                    else return 0;
                }
            }
        } else return 0;

        return 1;
    }
    public static void main(String[] args) {
        String[] board1 = {"O.X", ".O.", "..X"};
        String[] board2 = {"OOO", "...", "XXX"};
        String[] board3 = {"...", ".X.", "..."};
        System.out.println(solution(board3));
    }
}
