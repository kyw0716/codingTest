package sk000801.LEVEL3;
import java.util.*;

class Solution {
    //https://school.programmers.co.kr/learn/courses/30/lessons/87694
    //왜 길이를 2배 해야 하는지는 잘 모르겠슴...
    //문제를 편하게 풀기 위해 좌표를 2배로 놓고 계산!
    //시작점을 1로 설정해놓기 때문에 가장자리를 고려X
    //해당 위치가 사각형의 내부라면 큐에 넣을 수 없음!
    //초기값 1을 제외하고 2로 나눠 답을 구함
    static List<int[]> range = new ArrayList<>();
    static int[][] japyo = new int[102][102];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int ansX, ansY;
    static int answer = 0;
    public boolean check(int x, int y) {
        for(int[] val : range) {
            if(val[0]<x && val[1]<y && x<val[2] && y<val[3]) return true; 
        }
        return false;
    }
    public void  bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int cx = top[0];
            int cy = top[1]; 
            if(cx == ansX && cy == ansY) {answer = (top[2]-1)/2; return;}
            japyo[cx][cy] = top[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = top[0]+dx[i];
                int ny = top[1]+dy[i];

                if(!check(nx, ny) && japyo[nx][ny] < 0) {
                    q.add(new int[]{nx, ny, top[2]+1});
                }
            }
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        ansX = 2*itemX;
        ansY = 2*itemY;
        for(int i = 0; i < rectangle.length; i++) {
            range.add(new int[]{rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2});
            for(int x = rectangle[i][0]*2; x <= rectangle[i][2]*2; x++) {
                for(int y = rectangle[i][1]*2; y <= rectangle[i][3]*2; y++) {
                    japyo[x][y] -= 1;
                }
            }
        }
        
        bfs(characterX*2, characterY*2);
        
        return answer;
    }
}
