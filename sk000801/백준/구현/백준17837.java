package sk000801.백준.구현;
import java.util.*;
import java.io.*;

// nxn인 체스판에서 진행됨
// 사용하는 말의 개수 k개 -> 1~k로 번호가 붙음 / 이동방향 우상좌하 중 하나
// 하나의 말 위에 다른 말을 올릴 수 있음
// 각 칸 흰0, 빨1, 파2 중 하나

// 말이 4개 이상 하나의 칸에 쌓이는 순간 게임이 종료

// 족히 2시간은 쓴듯

//https://www.acmicpc.net/problem/17837
public class 백준17837 {
    static int n, k;
    static int[][] map;
    static List<Integer>[][] points;
    static List<Point> list = new ArrayList<>();
    static List<Point> change = new ArrayList<>();

    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};

    public static class Point {
        int x;
        int y;
        int direction;

        public Point(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public static void move() {
        for(int i = 1; i <= k; i++) {
            Point p = list.get(i-1);

            int nx = p.x+dx[p.direction];
            int ny = p.y+dy[p.direction];

            if(nx<0||nx>=n||ny<0||ny>=n||map[nx][ny] == 2) {
                int dir = 3-p.direction;
                list.get(i-1).direction = dir;

                int nx2 = p.x+dx[dir];
                int ny2 = p.y+dy[dir];

                if(nx2<0||nx2>=n||ny2<0||ny2>=n||map[nx2][ny2] == 2) continue;
                if(map[nx2][ny2] == 0) remove(p.x, p.y, nx2, ny2, i, false);
                if(map[nx2][ny2] == 1) remove(p.x, p.y, nx2, ny2, i, true);
            }
            else if(map[nx][ny] == 0) remove(p.x, p.y, nx, ny, i, false);
            else if(map[nx][ny] == 1) remove(p.x, p.y, nx, ny, i, true);

            if(isFinished()) break;
        }
    }

    public static void remove(int x, int y, int nx, int ny, int num, boolean reverse) {
        List<Integer> pre = points[x][y];
        List<Integer> temp = new ArrayList<>();

        int idx = 0;
        for(int j = 0; j < pre.size(); j++) {
            if(pre.get(j) == num) {
                idx = j;
                break;
            } 

            temp.add(pre.get(j));
        }

        if(reverse) {
            Collections.reverse(temp);
        }

        for(int i = idx; i < pre.size(); i++) {
            points[x][y].remove(idx);
        }

        for(int i = 0; i < temp.size(); i++) {
            list.get(temp.get(i)).x = nx;
            list.get(temp.get(i)).y = ny;

            points[nx][ny].add(temp.get(i));
        }
    }

    public static boolean isFinished() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(points[i][j].size() >= 4) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        points = new ArrayList[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                points[i][j] = new ArrayList<>();
            }
        }

        for(int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int direction = Integer.parseInt(st.nextToken())-1;

            points[x][y].add(i);
            list.add(new Point(x, y, direction));
        }

        int answer = 0;
        while(answer <= 1000) {
            answer++;
            move();
            if(isFinished()) break;
        }

        System.out.println(answer > 1000 ? -1 : answer);
    }
}
