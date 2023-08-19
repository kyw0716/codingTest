package sk000801.백준.그래프;
import java.util.*;

//백준 16236번
//53분 ,, BFS의 격렬한 응용 버전..
public class 아기상어 {
    static int n;
    static int[][] map;
    static int[] shark;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static int bfs() {
        int count = 0;
        int size = 2;
        int answer = 0;

        while(true) {
            int maxDist = Integer.MAX_VALUE;
            int x = Integer.MAX_VALUE; //다음 물고기 위치
            int y = Integer.MAX_VALUE;
            int[][] dist = new int[n][n]; //이동 거리 저장

            Queue<int[]> q = new LinkedList<>();
            q.add(shark);
           
            while(!q.isEmpty()) {
                int[] cur = q.poll();

                for(int i = 0; i < 4; i++) {
                    int nx = cur[0]+dx[i];
                    int ny = cur[1]+dy[i];

                    if(nx<0||nx>=n||ny<0||ny>=n) continue;
                    if(map[nx][ny] > size || dist[nx][ny] != 0) continue;
                    dist[nx][ny] = dist[cur[0]][cur[1]]+1;
                    if(map[nx][ny] != 0 && map[nx][ny] < size) {
                        if(maxDist > dist[nx][ny]) { //가장 가까운 물고기
                            maxDist = dist[nx][ny];
                            x = nx; 
                            y = ny;
                        } else if(maxDist == dist[nx][ny]) { //거리가 같다면
                            if(nx == x) { //가장 왼쪽
                                if(y > ny) {
                                    x = nx; 
                                    y = ny;
                                }
                            } else if (nx < x) { //가장 위쪽
                                x = nx; 
                                y = ny;
                            }
                        }
                    }

                    q.add(new int[]{nx, ny});
                }
            }

            if(x == Integer.MAX_VALUE && y == Integer.MAX_VALUE) break;
            //먹을 물고기가 없어 초기값이 그대로라면

            answer += dist[x][y]; //이동 횟수 -> 이동 시간(초)
            map[x][y] = 0; //먹혔으니까 빈칸으로 초기화

            shark = new int[]{x, y};
            count++;

            if(count == size) {
                size++;
                count = 0;
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
                if(map[i][j] == 9) {
                    shark = new int[]{i, j};
                    // 상어 위치 저장했으므로 값을 초기화 하여 이동하자
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(bfs());
    }
}
