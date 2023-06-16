package sk000801.복습;
import java.util.*;
public class 빛의경로사이클 {
    //15분
    //왼아래오른위
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static int check(int i, int j, int r, int[][][] road, String[] grid) {
        int count = 0;

        while(true) {
            if(road[i][j][r] == 1) break;

            count++;
            road[i][j][r] = 1;

            if(grid[i].charAt(j) == 'L') {
                r = (r+1)%4;
            } else if(grid[i].charAt(j) == 'R') {
                r = (r+3)%4;
            }

            i = (i+dx[r]+grid.length)%grid.length;
            j = (j+dy[r]+grid[0].length())%grid[0].length();
        }

        return count;
    }
    public static int[] solution(String[] grid) {
        int[][][] road = new int[grid.length][grid[0].length()][4];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < road.length; i++) {
            for(int j = 0; j < road[i].length; j++) {
                for(int r = 0; r < 4; r++) {
                    if(road[i][j][r] == 0) {
                        list.add(check(i, j, r, road, grid));
                    }
                }
            }
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] grid1 = {"SL", "LR"};
        String[] grid2 = {"S"};
        String[] grid3 = {"R", "R"};
        int[] res = solution(grid3);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
