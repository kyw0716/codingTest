package sk000801.백준.그래프;
import java.util.*;

//앗 일단 섬들을 구분해줘야 하나보다
//43분+30분, 헛발질..
//https://devowen.com/317
public class 다리만들기 {
    static int n;
    static int[][] road;
    static int[][] land;
    static int[][] count;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                count[i][j] =  -1;
                if(road[i][j] == 1) {
                    q.add(new int[]{i, j});
                    count[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(count[nx][ny] == -1) {
                    count[nx][ny] = count[cur[0]][cur[1]]+1;
                    land[nx][ny] = land[cur[0]][cur[1]];
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void indexLand() {
        int landIdx = 1;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
          for(int j = 0; j < n; j++) {
            if(road[i][j] == 1 && land[i][j] == 0) {
                land[i][j] = landIdx;
                q.add(new int[]{i, j});
                
                while(!q.isEmpty()) {
                    int[] cur = q.poll();

                    for(int r = 0; r < 4; r++) {
                        int nx = cur[0]+dx[r];
                        int ny = cur[1]+dy[r];

                        if(nx<0||ny<0||nx>=n||ny>=n) continue;
                        if(road[nx][ny] == 1 && land[nx][ny] == 0) {
                            land[nx][ny]= landIdx;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }

                landIdx++;
            }
          }
       }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        road = new int[n][n];
        land = new int[n][n];
        count = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                road[i][j] = in.nextInt();
            }
        }

        indexLand();

        bfs();

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int r = 0; r < 4; r++) {
                    int nx = i+dx[r];
                    int ny = j+dy[r];

                    if(nx<0||nx>=n||ny<0||ny>=n) continue;
                    if(land[i][j] != land[nx][ny]) {
                        ans = Math.min(ans, count[i][j]+count[nx][ny]);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
