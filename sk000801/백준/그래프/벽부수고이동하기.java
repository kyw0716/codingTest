package sk000801.백준.그래프;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Queue<int[]> q = new LinkedList<>();

    public static class Node {
        public int x;
        public int y;
        public int count;
        public int wall;

        public Node(int x,  int y, int count, int wall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 1, 0));
        visited[x][y][0] = true;
        visited[x][y][1] = true;

        while(!q.isEmpty()) {
            Node jap = q.poll();

            if(jap.x == n-1 && jap.y == m-1) {return jap.count;}

            for(int i = 0; i < 4; i++) {
                int nx = jap.x+dx[i];
                int ny = jap.y+dy[i];

                if(nx>=0 && nx <n && ny>=0 && ny<m && !visited[nx][ny][jap.wall]) {
                    if(map[nx][ny] == 0) {
                        if(!visited[nx][ny][0]) {
                            q.add(new Node(nx, ny, jap.count+1, jap.wall));
                            visited[nx][ny][jap.wall] = true;
                        }
                    } else {
                        if(jap.wall == 0 && !visited[nx][ny][1]) {
                            q.add(new Node(nx, ny, jap.count+1, 1));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }
}

//최단경로에 대한 값을 가져가기 위해 int형으로 만들어
//어떤 클래스를 선언해서 풀고싶지 않았는데ㅠㅠㅠ
//