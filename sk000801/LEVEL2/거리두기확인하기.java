package sk000801.LEVEL2;
import java.util.*;
//결국에는 탐색으로 풀어야 하나봄..
//1시간.....
class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    boolean[][] visited = new boolean[5][5];
    boolean check = true;
    public void dfs(int x1, int y1, int x2, int y2, char[][] room) {
        visited[x1][y1] = true;

        for(int d=0; d<4; d++){
            int nx = x1 + dx[d];
            int ny = y1 + dy[d];

            if(nx<0 || nx>=5 || ny<0 || ny>=5 || visited[nx][ny]) continue;

            // 거리가 2 이하인 곳을 탐색
            if(Math.abs(nx-x2)+Math.abs(ny-y2) <= 2) {
                if (room[nx][ny] == 'P' || room[nx][ny] == 'O') {
                    dfs(nx, ny, x2, y2, room);

                    if(room[nx][ny] == 'P') check = false;
                }
            }
        }
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] room = new char[5][5];
        
        for(int i = 0; i < 5; i++) {
                room = new char[5][5];
                visited = new boolean[5][5];
                check = true;
                List<int[]> people = new ArrayList<>();
                
                for (int j = 0; j < 5; j++) {
                    char[] tmp = places[i][j].toCharArray();
                    for (int k = 0; k < 5; k++) {
                        room[j][k] = tmp[k];
                        if (room[j][k] == 'P') {
                            people.add(new int[]{j, k});
                        }
                    }
                }
                
                for(int t=0; t<people.size(); t++){
                    int[] person = people.get(t);
                    dfs(person[0], person[1], person[0], person[1], room);
                }
                
                if(check) answer[i] = 1;
        }
        return answer;
    }
}

//조건문 만으로 풀었는데 틀린 풀이
// class Solution {
//     public boolean check(String[][] p, List<int[]> people) {
//         for(int i = 0; i < people.size(); i++) {
//             for(int j = 0; j < people.size(); j++) {
//                 if(i==j) continue;
//                 int[] a = people.get(i);
//                 int[] b = people.get(j);
//                 if(Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]) < 2) return false; 
//                 if(Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]) == 2) {
//                     if(a[0] == b[0]) {
//                         if(!p[a[0]][(a[1]+b[1])/2].equals("X")) return false;
//                     } 
//                     if(a[1] == b[1]) {
//                         if(!p[(a[0]+b[0])/2][a[1]].equals("X")) return false;
//                     }
//                     else {
//                         if(!p[b[0]][a[1]].equals("X") && !p[a[0]][b[1]].equals("X")) return false;
//                     }
//                 }
//             }
//         }
//         return true;
//     }
//     public int[] solution(String[][] places) {
//         int[] answer = new int[5]; //거리두기 지키는 시험장만 1 넣어주자
//         for(int i = 0; i < 5; i++) {
//             List<int[]> people = new ArrayList<>();
//             String[][] p = new String[5][5];
//             for(int j = 0; j < 5; j++) {
//                 p[j] = places[i][j].split("");
//             }
//             for(int x = 0; x < 5; x++) {
//                 for(int y = 0; y < 5; y++) {
//                     if(p[x][y].equals("P")) people.add(new int[]{x, y});
//                 }
//             }
//             if(check(p, people)) answer[i] = 1;
//         }
//         return answer;
//     }
// }
