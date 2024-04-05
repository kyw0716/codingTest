package sk000801.코드트리;
import java.util.*;
import java.io.*;

public class 왕실의기사대결 {
    static int l, n, q;
    static int[][] map;
    static int[][] knightmap;
    static Knight[] knights;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static class Knight {
        int r;
        int c;
        int h;
        int w;
        int k;
        boolean isDead = false;
        boolean isDamaged = false;
        int damage = 0;

        public Knight(int r, int c, int h, int w, int k) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
        }
    }

    public static boolean canMove(int idx, int d) {
        for(int i = knights[idx].r; i < knights[idx].r+knights[idx].h; i++) {
            for(int j = knights[idx].c; j < knights[idx].c+knights[idx].w; j++) {
                int nx = i+dx[d];
                int ny = j+dy[d];

                if(nx<1||ny<1||nx>l||ny>l||map[nx][ny] == 2) return false;

                int knightNum = knightmap[nx][ny];

                if(knightNum == 0 || knightNum == idx) continue;
                
                if(!canMove(knightNum, d)) return false;
            }
        }

        return true;
    }

    public static void moveDirection(int idx, int d) {
        if(d == 0) {
            for (int r = knights[idx].r; r < knights[idx].r + knights[idx].h; r++) {
                for (int c = knights[idx].c; c < knights[idx].c + knights[idx].w; c++) {
                    int nx =  r + dx[d];
                    int ny =  c + dy[d];

                    knightmap[r][c] = 0;
                    knightmap[nx][ny] = idx;
                }
            }
        }

        if(d == 1) {
            for (int r = knights[idx].r + knights[idx].h - 1; r >= knights[idx].r; r--) {
                for (int c = knights[idx].c; c < knights[idx].c + knights[idx].w; c++) {
                    int nx = r + dx[d];
                    int ny = c + dy[d];

                    knightmap[r][c] = 0;
                    knightmap[nx][ny] = idx;
                }
            }
        }

        if(d == 2) {
            for (int c = knights[idx].c + knights[idx].w - 1; c >= knights[idx].c; c--) {
                for (int r = knights[idx].r; r < knights[idx].r + knights[idx].h; r++) {
                    int nx = r + dx[d];
                    int ny = c + dy[d];

                    knightmap[r][c] = 0;
                    knightmap[nx][ny] = idx;
                }
            }
        }

        if(d == 3) {
            for (int c = knights[idx].c; c < knights[idx].c + knights[idx].w; c++) {
                for (int r = knights[idx].r; r < knights[idx].r + knights[idx].h; r++) {
                    int nx = r + dx[d];
                    int ny = c + dy[d];

                    knightmap[r][c] = 0;
                    knightmap[nx][ny] = idx;
                }
            }
        }
    }

    public static void moveKnight(int idx, int d) {
        for(int i = knights[idx].r; i < knights[idx].r+knights[idx].h; i++) {
            for(int j = knights[idx].c; j < knights[idx].c+knights[idx].w; j++) {
                int nx = i+dx[d];
                int ny = j+dy[d];

                int knightNum = knightmap[nx][ny];

                if(knightNum == 0 || knightNum == idx) continue;

                moveKnight(knightNum, d);
            }
        }

        moveDirection(idx, d);

        knights[idx].isDamaged = true;
        knights[idx].r += dx[d];
        knights[idx].c += dy[d];
    }

    public static void move(int idx, int d) {
        if(!canMove(idx, d)) return;

        moveKnight(idx, d);
        knights[idx].isDamaged = false;

        for(int i = 1; i <= n; i++) {
            if(!knights[i].isDamaged) continue;

            int damageNum = 0;
            for(int x = knights[i].r; x < knights[i].r+knights[i].h; x++) {
                for(int y = knights[i].c; y < knights[i].c+knights[i].w; y++) {
                    if(x < 1 || y < 1 || x > l || y > l) continue;

                    if(map[x][y] == 1) damageNum++;
                }
            }

            knights[i].damage += damageNum;
            knights[i].k -= damageNum;

            if(knights[i].k <= 0) {
                knights[i].isDead = true;

                for(int x = knights[i].r; x < knights[i].r+knights[i].h; x++) {
                    for(int y = knights[i].c; y < knights[i].c+knights[i].w; y++) {
                        knightmap[x][y] = 0;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        map = new int[l+1][l+1];
        knightmap = new int[l+1][l+1];
        knights = new Knight[n+1];

        for(int i = 1; i <= l; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= l; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken()); //세로길이
            int w = Integer.parseInt(st.nextToken()); //가로길이
            int k = Integer.parseInt(st.nextToken()); //초기체력

            knights[i] = new Knight(r, c, h, w, k);

            for(int x = r; x < r+h; x++) {
                for(int y = c; y < c+w; y++) {
                    knightmap[x][y] = i;
                }
            }
        }

        for(int i = 1; i <= q; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(knights[idx].r < 1 || knights[idx].c < 1 || knights[idx].r > l || knights[idx].c > l) continue;
            if(knights[idx].isDead) continue;

            move(idx, d);

            for(int j = 1; j <= n; j++) {
                knights[j].isDamaged = false;
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(!knights[i].isDead) answer += knights[i].damage;
        }

        System.out.println(answer);
    }
}
