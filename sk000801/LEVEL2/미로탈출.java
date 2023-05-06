package sk000801.LEVEL2;
import java.util.*;
//42분
//혼자 문제 못 알아듣고 난리침 ㅋ
// 1. 두 배열의 값이 같다고 == 남발하지 말자. 얘는 주솟값을 비교함
// 2. 문제 잘 읽자. maps[i]의 길이가 5라고 안함
class 미로탈출 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    public int bfs(int[] start, int[] fin, String[][] map) {
        int[][] val = new int[map.length][map[0].length];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[start[0]][start[1]] = true;
        q.add(start);
        
        while(!q.isEmpty()) {
            int[] top = q.poll();
            
            if(top[0] == fin[0] && top[1] == fin[1]) return val[fin[0]][fin[1]];
            
            for(int i = 0; i < 4; i++) {
                int nx = top[0]+dx[i];
                int ny = top[1]+dy[i];
                if(nx<0||nx>=map.length||ny<0||ny>=map[0].length) continue;
                if(!map[nx][ny].equals("X") && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    val[nx][ny] = val[top[0]][top[1]]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        return -1;
    }
    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] fin = new int[2];
        String[][] map = new String[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++) {
            map[i] = maps[i].split("");
        }
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j].equals("S")) start = new int[]{i, j};
                if(map[i][j].equals("L")) lever = new int[]{i, j};
                if(map[i][j].equals("E")) fin = new int[]{i, j};
            }
        }
        int answer = bfs(start, lever, map);
        if(answer == -1) return -1;
        int temp = bfs(lever, fin, map);
        if(temp == -1) return -1;
        return answer+temp;
    }
}
