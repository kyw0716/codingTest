package sk000801.백준.구현;
import java.io.*;
import java.util.*;

public class 으악 {
    static int dx[] = {0,0,0,-1,1};
    static int dy[] = {0,1,-1,0,0};
    static int map[][];
    static int n,k;
    static int answer=0;
    static Point arr[];
    static ArrayList<Integer>points[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        k = Integer.parseInt(t[1]);
        arr = new Point[k+1];
        map = new int[n+1][n+1];
        
        points = new ArrayList[n+1][n+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                points[i][j] = new ArrayList<>();
            }
        }
        
        for(int i=1; i<=n; i++) {
            String[] tt= br.readLine().split(" ");
            for(int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(tt[j-1]);
            }
        }
        
        for(int i=1; i<=k; i++) {
            String [] ttt = br.readLine().split(" ");
            int r = Integer.parseInt(ttt[0]);
            int c = Integer.parseInt(ttt[1]);
            int dir = Integer.parseInt(ttt[2]);
            points[r][c].add(i);
            arr[i] = new Point(r,c,dir);
        }
        
        while(answer<=1000) {
            answer++;
            move();
            if(end()) break;
        }

        System.out.println(answer >= 1000 ? -1 : answer);
    }

    public static void move() {
        for(int i=1; i<=k; i++) {
            Point a = arr[i];
            int nx = a.x+dx[a.dir];
            int ny = a.y+dy[a.dir];
            
            if(!isRange(nx,ny) || map[nx][ny]==2) {
                arr[i].dir = arr[i].dir%2==0 ? arr[i].dir-1 : arr[i].dir+1;
                int nx2 = arr[i].x + dx[arr[i].dir];
                int ny2 = arr[i].y + dy[arr[i].dir];
                if(isRange(nx2,ny2)&&map[nx2][ny2]!=2) {
                    if(map[nx2][ny2]==0) {
                        remove(a.x,a.y,nx2,ny2,i,false);
                    }
                    else {
                        remove(a.x,a.y,nx2,ny2,i,true);
                    }
                }
                
            }
            else if(isRange(nx,ny) && map[nx][ny] ==0) {
                remove(a.x,a.y,nx,ny,i,false);
            }
            else if(isRange(nx,ny) &&map[nx][ny]==1) {
                remove(a.x,a.y,nx,ny,i,true);
            }

            if(end()) return;
        }
    }

    public static boolean end() {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(points[i][j].size()>=4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void remove(int bx, int by, int nx, int ny, int num,boolean check) {
        int size = points[bx][by].size();
        boolean flag = true;
        List<Integer> temp = new ArrayList<>();

        int idx=0;
        for(int i=0; i<size; i++) {
            if(points[bx][by].get(i) == num) {
                idx = i;
                flag = false;
            }

            if(!flag) {
                temp.add(points[bx][by].get(i));
            }
        }

        if(check) {
            Collections.reverse(temp);
        }

        for(int i= idx; i<size; i++) {
            points[bx][by].remove(idx); 
        }

        for(int i=0; i<temp.size(); i++) {
            arr[temp.get(i)].x = nx;
            arr[temp.get(i)].y=ny;
            points[nx][ny].add(temp.get(i));
        }
        
    }

    public static boolean isRange(int x, int y) {
        if(x>=1 && y>=1 && x<=n && y<=n) {
            return true;
        }
        return false;
    }
}

class Point{
    int x,y,dir;
    Point(int x, int y, int dir){
        this.x=x;
        this.y=y;
        this.dir=dir;
    }
}
