package sk000801.LEVEL3;
import java.util.*;

//bfs까지는 알겠는데 어떻게 풀어야 할 지 도통 모르겠다..
//3중 배열을 활용해 같은 인덱스에서 상하좌우 방문 여부를 판별
//주어진 board 배열의 같은 인덱스라도 현재 값이 더 최소라면 그 값으로 갱신시켜줌
public class 경주로건설 {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][][] visited;
    public class Node {
        int i; int j; int dir; int cost;
        
        public Node(int i, int j, int dir, int cost) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.cost = cost;
        }
    }
    public int bfs(int[][] board) {
        int x = 0; int y = 0; int dir = -1; int cost = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, dir, cost));
        int min = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.i == board.length-1 && cur.j == board.length-1) {
                min = Math.min(min, cur.cost);
            }
            
            for(int r = 0; r < 4; r++) {
                int nx = cur.i+dx[r];
                int ny = cur.j+dy[r];
                
                if(nx<0||nx>=board.length||ny<0||ny>=board.length||board[nx][ny] == 1) continue;
                int next = cur.cost;
                if(cur.dir == -1 || cur.dir == r) next += 100;
                else next += 600;
                    
                if(!visited[nx][ny][r] || board[nx][ny] >= next) {
                    q.add(new Node(nx, ny, r, next));
                    visited[nx][ny][r] = true;
                    board[nx][ny] = next;
                }
            }
        } 
        
        return min;
    }
    public int solution(int[][] board) {
        visited = new boolean[board.length][board.length][4];
        return bfs(board);
    }
}