package sk000801.LEVEL2;
import java.util.*;
//미끄러지듯이 이동하는게 이 문제의 포인트!
//62분 + 풀이..
public class 리코쳇로봇 {
    static int n, m, sx, sy, ex, ey; //startx/y, endx/y !
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        visit[sx][sy] = true;
        q.add(new int[]{sx, sy, 0});

        while(!q.isEmpty()){
            int[] point = q.poll();

            int x = point[0];
            int y = point[1];
            int dist = point[2];

            if(x==ex && y==ey) return dist;

            for(int i=0;i<4;i++){
                int nextX = x;
                int nextY = y;

                //여기가 원래의 풀이들과 다른 부분인거같움
                for(int k=1;k<=Math.max(n, m);k++){
                    nextX+=dx[i];
                    nextY+=dy[i];

                    if(nextX<0 || nextX>=n || nextY<0 || nextY>=m || map[nextX][nextY] =='D') {
                        nextX-=dx[i];
                        nextY-=dy[i];
                        break;
                    }
                }

                if(visit[nextX][nextY]) continue;

                visit[nextX][nextY] = true;
                q.add(new int[]{nextX, nextY, dist+1});
            }
        }

        return -1;
    }

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();

        map = new char[n][m];
        visit = new boolean[n][m];

        for(int i=0;i<n;i++) {
            map[i] = board[i].toCharArray();
            for(int j=0;j<m;j++) {
                if(map[i][j] == 'R'){
                    sx = i;
                    sy = j;
                }
                else if(map[i][j] == 'G'){
                    ex = i;
                    ey = j;
                }
            }    
        }

        return bfs();
    }
}

//1번 망한 풀이
// class Solution {
//         int[] dx = {-1,0,1,0};
//         int[] dy = {0,-1,0,1};
//         int[] dest = new int[2];
//         int[] first = new int[2];
//         String[][] game;
//         public int bfs(int a, int b) {
//             Queue<int[]> q = new LinkedList<>();
//             q.add(new int[]{a,b});
//             int[][] visited = new int[game.length][game[0].length];
            
//             for(int i = 0; i < visited.length; i++) {
//                 Arrays.fill(visited[i], -1);
//             }
//             visited[a][b] = 0;
            
//             while(!q.isEmpty()) {
//                 int[] top = q.poll();
                
//                 if(top[0] == dest[0] && top[1] == dest[1]) return visited[top[0]][top[1]];
                
//                 for(int i = 0; i < 4; i++) {
//                     int nx = top[0];
//                     int ny = top[1];
                    
//                     while(true) {
//                         if(nx<0||nx>=visited.length||ny<0||ny>=visited[0].length||visited[nx][ny] != -1||game[nx][ny].equals("D")) {
//                             q.add(new int[]{nx-dx[i], ny-dy[i]});
//                             break;
//                         } 
//                         else if(game[nx][ny].equals(".")) {
//                             nx += dx[i];
//                             ny += dy[i];
//                             visited[nx][ny] = visited[top[0]][top[1]]+1;
//                         } 
//                     } 
//                 }
//             }
            
//             return -1;
//         }
//         public int solution(String[] board) {
//             game = new String[board.length][board[0].length()];
//             for(int i = 0; i < board.length; i++) {
//                 game[i] = board[i].split("");
//                 for(int j = 0; j < game[i].length; j++) {
//                     if(game[i][j].equals("R")) first = new int[]{i, j};
//                     if(game[i][j].equals("G")) dest = new int[]{i, j};
//                 }
//             }
            
//             return bfs(first[0], first[1]);
//         }
//  }