class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        for (String s : keyinput) {
            if(s.equals("up")) answer[1] += 1;
            if(s.equals("down")) answer[1] += -1;
            if(answer[1] > board[1]/2) answer[1] = board[1]/2;
            if(answer[1] < -board[1]/2) answer[1] = -board[1]/2;
            if(s.equals("left")) answer[0] += -1;
            if(s.equals("right")) answer[0] += 1;
            if(answer[0] > board[0]/2) answer[0] = board[0]/2;
            if(answer[0] < -board[0]/2) answer[0] = -board[0]/2;
        }
        return answer;
    }
}