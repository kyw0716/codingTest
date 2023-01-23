package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

// 현재 노드와 이동할 노드의 값 차이가 l이상 r이하인 노드만 이동하도록 함
// 방문한 노드들을 차례대로 리스트에 넣어줌 or boolean형 배열로
// 노드들의 방문이 끝났다면 인구 이동을 실시한다

public class 인구이동 {
    static int n;
    static int l,r;
    static int[][] world;
    static boolean[][] visited;
    static List<int[]> list;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();

        q.add(new int[]{x, y});
        list.add(new int[]{x,y});
        visited[x][y] = true;

        int sum = world[x][y];
        while(!q.isEmpty()) {
            int[] jap = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(!visited[nx][ny]) {
                    int chai = Math.abs(world[jap[0]][jap[1]]-world[nx][ny]);
                    if(chai>=l && chai<=r) {
                        q.add(new int[]{nx, ny});
                        list.add(new int[]{nx, ny});
                        sum += world[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);
        world = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                world[i][j] = Integer.parseInt(s[j]);
            }
        }

        int result = 0;
        boolean escape = true;

        while(escape) {
            escape = false;
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j);
                        if(list.size()>1) {
                            sum /= list.size();
                            for(int p = 0; p < list.size(); p++) {
                                world[list.get(p)[0]][list.get(p)[1]] = sum;
                                escape = true;
                            }
                        }
                    }
                }
            }
            result++;
        }

        System.out.println(result-1);
    }
}
