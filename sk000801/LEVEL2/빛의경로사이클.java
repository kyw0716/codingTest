package sk000801.LEVEL2;

//https:jisunshine.tistory.com/175 풀이 참조 
import java.util.*;
class 빛의경로사이클 {
    //어떻게 풀어야 할까
    //44분 56초
    //어차피 상하좌우 이동해야 하니까 
    //왼쪽, 아래쪽, 오른쪽, 위쪽
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    public int check(String[] grid, int[][][] light, int x, int y, int z) {
        int count = 0;
        
        while(true) {
            if(light[x][y][z] == 1) break;
            
            count++;
            light[x][y][z] = 1;
            
            String s = grid[x];
            if(s.charAt(y) == 'R') {
                z = (z + 1) % 4;
            } else if(s.charAt(y) == 'L') {
                z = (z + 3) % 4;
            }
            
            x = (x+dx[z]+grid.length)%grid.length;
            y = (y+dy[z]+grid[0].length())%grid[0].length();
        }
        
        return count;
    }
    public int[] solution(String[] grid) {
        List<Integer> ans = new ArrayList<>();
        //마지막 4는 한 위치의 상하좌우 
        int[][][] light = new int[grid.length][grid[0].length()][4];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length(); j++) {
                for(int r = 0; r < 4; r++) {
                    if(light[i][j][r] == 0) {
                        ans.add(check(grid, light, i, j, r));
                    }
                }
            }
        }
        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
