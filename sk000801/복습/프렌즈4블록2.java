package sk000801.복습;
import java.util.*;

//42분
//제거 하는 걸 처음에 2중 for문으로만 생각했는데(x의 값을 증가시켜가면서 아래는 비어있고 위에는 채워져있으면 내려주는)
//생각해보니 이건 두 칸 이상 띄워져 있을 때는 아래 칸으로 내려가질 못하기 때문에 3중 for문이 필요했다
//그리고 잘못 생각해서 해당되는 블럭의 값을 x로 초기화 시켜주지 않아 중간에 문제가 발생했다
//여러모로 생각할 거리가 많은 문제
public class 프렌즈4블록2 {
    static int[] dx = {0,1,1};
    static int[] dy = {1,0,1};
    static List<int[]> list = new ArrayList<>();
    public static boolean check(String[][] block) {
        boolean check = false;
        for(int i = 0; i < block.length; i++) {
            for(int j = 0; j < block[0].length; j++) {
                String s = block[i][j];
                if(s.equals("x")) continue;
                int count = 0;
                for(int r = 0; r < 3; r++) {
                    int nx = i+dx[r];
                    int ny = j+dy[r];
                    if(nx<0||nx>=block.length||ny<0||ny>=block[0].length) break;
                    if(s.equals(block[nx][ny])) count++;
                }
                if(count == 3) {
                    list.add(new int[]{i, j});
                    check = true;
                }
            }
        }
        return check;
    }
    public static void remove(String[][] block) {
        for(int i = 0; i < list.size(); i++) {
            int[] top = list.get(i);
            block[top[0]][top[1]] = "x";
            for(int j = 0; j < 3; j++) {
                int nx = top[0]+dx[j];
                int ny = top[1]+dy[j];
                block[nx][ny] = "x";
            }
        }
        list.clear();
    }
    public static void move(String[][] block) {
        for(int y = 0; y < block[0].length; y++) {
            for(int x = block.length-1; x >= 0; x--) {
                if(block[x][y].equals("x")) {
                    for(int r = x-1; r >= 0; r--) {
                        if(!block[r][y].equals("x")) {
                            block[x][y] = block[r][y];
                            block[r][y] = "x";
                            break;
                        }
                    }
                }
            }
        }
    }
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] block = new String[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++) {
            block[i] = board[i].split("");
        }

        while(check(block)) {
            remove(block);
            move(block);
        }

        for(int i = 0; i < block.length; i++) {
            for(int j = 0; j < block[0].length; j++) {
                if(block[i][j].equals("x")) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int m1 = 4; int n1 = 5;
        String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int m2 = 6; int n2 = 6;
        String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(solution(m2, n2, board2));
    }
}
