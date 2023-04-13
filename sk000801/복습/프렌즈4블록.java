package sk000801.복습;
import java.util.*;

//일단 상하좌우 4개의 블록이 같은지 봐야함
//한 턴을 돌고 난 후에 얘네를 사라지게 해야 함
//이게 반복되다가 pop 될 일이 없으면 값을 반환해줘야지
//41분 가량 ..... 
public class 프렌즈4블록 {
    public static int[] dx = {0,1,0,1};
    public static int[] dy = {0,0,1,1};
    public static List<int[]> set = new ArrayList<>();
    public static boolean check(String[][] map) {
        boolean check = false;
        for(int a = 0; a < map.length; a++) {
            for(int b = 0; b < map[0].length; b++) {
                String s = map[a][b];
                int count = 0;
                if(!s.equals("x")) {
                    for(int x = 0; x < 4; x++) {
                        int nx = a+dx[x];
                        int ny = b+dy[x];
                        if(nx<0||ny<0||nx>=map.length||ny>=map[0].length) break;
                        if(map[nx][ny].equals(s)) count++;
                    }
                    if(count == 4) {set.add(new int[]{a, b}); check =  true;}
                }
            }
        }  
        return check;
    }
    public static void pop(String[][] map) {
        for(int i = 0; i < set.size(); i++) {
            int[] cur = set.get(i);
            for(int j = 0; j < 4; j++) {
                int nx = cur[0]+dx[j];
                int ny = cur[1]+dy[j];
                map[nx][ny] = "x";
            }
        }
    } 
    //여기가 관건 x값만 바뀌고 큰 x값부터 차례대로 탐색
    public static void move(String[][] map) {
        for(int i = 0; i < map[0].length; i++) {
            for(int j = map.length-1; j >= 0; j--) {
                if(map[j][i].equals("x")) {
                    for(int r = j-1; r >= 0; r--) {
                        if(!map[r][i].equals("x")) {
                            map[j][i] = map[r][i];
                            map[r][i] = "x";
                            break;
                        }
                    }
                }
            }
        }
    }
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] map = new String[m][n];
        for(int i = 0; i < m; i++) {
            String[] s = board[i].split("");
            for(int j = 0; j < n; j++) {
                map[i][j] = s[j];
            }
        }

        while(check(map)) {
            pop(map);
            move(map);
            set = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j].equals("x"))answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int m1 = 4; int n1 = 5;
        String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int answer = solution(m1, n1, board1);
        System.out.println(answer);
    }
}
