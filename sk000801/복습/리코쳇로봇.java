package sk000801.복습;
import java.util.*;

//25분
//미끄러지듯이 이동하는 방향으로 장애물이 아닐 때까지 탐색하는 것이 힘들었다..
public class 리코쳇로봇 {
    static int[] start = new int[2];
    static int[] dest = new int[2];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static char[][] map;
    static boolean[][] visited;
    static int[][] point;
    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == dest[0] && cur[1] == dest[1]) {
                return point[cur[0]][cur[1]];
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur[0];
                int ny = cur[1];

                //여기가 제일 힘들었다..
                for(int j = 0; j < Math.max(point.length, point[0].length); j++) {
                    nx += dx[i];
                    ny += dy[i];

                    if(nx<0||nx>=map.length||ny<0||ny>=map[0].length||map[nx][ny] == 'D') {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }

                //근데 왜 방문처리는 for문을 나오고서야 해야 정답일까
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                point[nx][ny] = point[cur[0]][cur[1]]+1;
                q.add(new int[]{nx, ny});
            }
        }

        return -1;
    }
    public static int solution(String[] board) {
        map = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        point = new int[board.length][board[0].length()];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R') start = new int[]{i, j};
                if(map[i][j] == 'G') dest = new int[]{i, j};
            }
        }

        return bfs();
    }
    public static void main(String[] args) {
        String[] board1 = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] board2 = {".D.R", "....", ".G..", "...D"};
        System.out.println(solution(board2));
    }
}
