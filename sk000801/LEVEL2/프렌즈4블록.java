package sk000801.LEVEL2;
import java.util.*;

class Solution {
    int m1, n1;
    List<int[]> set = new ArrayList<>();
    public int[] dx = {0, 1, 0, 1};
    public int[] dy = {0, 0, 1, 1};
    public boolean check(String[][] board) {//아직사라질게 남았나 보는 함수
        boolean check = false;
        for(int i = 0; i < m1; i++) {
            for(int j = 0; j < n1; j++) {
                int count = 0;
                String ans = board[i][j];
                if(!ans.equals("x")) { // 이걸 안해주면 x일때도 체크가 되어 문제가 발생함
                    for(int r = 0; r < 4; r++) {
                    int nx = i+dx[r];
                    int ny = j+dy[r];
                    if(nx<0||nx>=m1||ny<0||ny>=n1) break;
                    if(ans.equals(board[nx][ny])) count++;
                    }
                    if(count == 4) {check = true; set.add(new int[]{i, j});}
                } 
            }
        }
        return check;
    }
    public void move(String[][] board) { //아래로 내려가는 함수
        for(int i = 0; i < n1; i++) {
            for(int j = m1-1; j >= 0; j--) {
                if(board[j][i].equals("x")) {
                    for(int r = j-1; r >= 0; r--) {
                        if(!board[r][i].equals("x")) {
                            board[j][i] = board[r][i];
                            board[r][i] = "x";
                            break;
                        }
                    }
                }
            }
        }
    }
    public void pop(String[][] board) {
        for(int i = 0; i < set.size(); i++) {
            int[] block = set.get(i);
            for(int j = 0; j < 4; j++) {
                int nx = block[0]+dx[j];
                int ny = block[1]+dy[j];
                board[nx][ny] = "x";
            }
        }
    }
    public int solution(int m, int n, String[] board) {
        m1 = m;
        n1 = n;
        String[][] bo = new String[m][n];
        for(int i = 0; i < m; i++) {
            String[] s = board[i].split("");
            for(int j = 0; j < n; j++) {
                bo[i][j] = s[j];
            }
        }
        
        while(check(bo)) {
            pop(bo);
            move(bo);
            set = new ArrayList<>();
        }
        
        int answer = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(bo[i][j].equals("x")) answer++;
            }
        }
        
        return answer;
    }
}
