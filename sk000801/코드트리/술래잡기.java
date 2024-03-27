package sk000801.코드트리;

//https://www.codetree.ai/training-field/frequent-problems/problems/hide-and-seek/description?page=1&pageSize=20
import java.util.*;
import java.io.*;

//128분 + 오류 디버깅까지... 풀이 참조해서 풀었는데도

public class 술래잡기 {
    static int n,m,h,k;
    static Runner[] runners;
    static boolean[][] trees;
    static int[] catcher;
    static int len = 0;
    static int count = 0;
    static int curLen = 1;
    static boolean opposite = false;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dx2 = {-1,0,1,0};
    static int[] dy2 = {0,1,0,-1};

    public static class Runner {
        int x;
        int y;
        int dir;
        boolean dead;

        public Runner(int x, int y, int dir, boolean dead) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.dead = false;
        }
    }

    public static void run() {
        for(Runner r : runners) {
            if(r.dead) continue;
            if(Math.abs(r.x-catcher[0])+Math.abs(r.y-catcher[1]) > 3) continue;

            int nx = r.x+dx[r.dir];
            int ny = r.y+dy[r.dir];

            if(nx>=1&&ny>=1&&nx<=n&&ny<=n) {
                if(nx != catcher[0] || ny != catcher[1]) {
                    r.x = nx;
                    r.y = ny;
                }                
            }
            else {
                r.dir = r.dir <= 1 ? 1-r.dir : 5-r.dir;

                int nx2 = r.x+dx[r.dir];
                int ny2 = r.y+dy[r.dir];

                if(nx2>=1&&ny2>=1&&nx2<=n&&ny2<=n) {
                    if(nx2 != catcher[0] || ny2 != catcher[1]) {
                        r.x = nx2;
                        r.y = ny2;
                    }
                } 
            }
        }
    }

    public static int catchRunner() {
        int count = 0;

        int x = catcher[0];
        int y = catcher[1];
        int dir = catcher[2];

        for(int i = 0; i <= 2; i++) {
            int nx = x+dx2[dir]*i;
            int ny = y+dy2[dir]*i;

            if(nx<1||ny<1||nx>n||ny>n) break;
            if(trees[nx][ny]) continue;

            //System.out.println("캐쳐: "+nx+" "+ny);

            for(Runner r : runners) {
                if(r.dead) continue;
                if(r.x == nx && r.y == ny) {
                    count++;
                    r.dead = true;
                }
            }
        }

        return count;
    }

    public static void moveCatcher() {
        int x = catcher[0];
        int y = catcher[1];
        int dir = catcher[2];

        int nx = x+dx2[dir];
        int ny = y+dy2[dir];

        len++;

        if(len == curLen) {
            len = 0;
            count++;

            if(!opposite) {
                dir = (dir+1)%4;
            } else {
                dir = (dir+3)%4;
            }

            if(count == 2) {
                count = 0;
                if(!opposite) curLen++;
                else curLen--;
            }
        }

        if(nx == 1 && ny == 1) {
            opposite = true;
            curLen = n-1;
            dir = 2;
            count = -1;
            len = 0;
        } else if(nx == (n+1)/2 && ny == (n+1)/2) {
            opposite = false;
            curLen = 1;
            dir = 0;
            count = 0;
            len = 0;
        }

        catcher = new int[]{nx, ny, dir};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        runners = new Runner[m];
        trees = new boolean[n+1][n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            
            if(direction == 1) runners[i] = new Runner(x, y, 0, false);
            else runners[i] = new Runner(x, y, 2, false);
        }

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trees[x][y] = true;
        }

        int answer = 0;
        catcher = new int[]{(n+1)/2, (n+1)/2, 0};
        for(int i = 1; i <= k; i++) {
            run();
            moveCatcher();
            answer += i*catchRunner();
            //System.out.println(i+"번 점수 : "+answer);
        }

        System.out.println(answer);
    }
}