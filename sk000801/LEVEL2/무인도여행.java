package sk000801.LEVEL2;
import java.util.*;

//단순 bfs문제
//17분!!
//방문처리도 안하고 dy배열 값을 잘못 넣어서 헤맸다 하하
class Solution {
    int n;
    List<Integer> days = new ArrayList<>();
    boolean[][] visited;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    public int bfs(int x, int y, String[][] map, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int days = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            days += Integer.parseInt(map[cur[0]][cur[1]]);
            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(nx<0||ny<0||nx>=map.length||ny>=map[0].length) continue;
                if(!map[nx][ny].equals("X") && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return days;
    }
    public int[] solution(String[] maps) {
        String[][] map = new String[maps.length][maps[0].length()];
        for(int i = 0; i < map.length; i++) {
            map[i] = maps[i].split("");
        }

        visited = new boolean[map.length][map[0].length];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(!map[i][j].equals("X") && !visited[i][j]) {
                    int val = bfs(i, j, map, visited);
                    if(val>0) days.add(val);
                }
            };
        }
        Collections.sort(days);
        if(days.size() == 0) return new int[]{-1};
        int[] answer = new int[days.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = days.get(i);
        }
        return answer;
    }
}
