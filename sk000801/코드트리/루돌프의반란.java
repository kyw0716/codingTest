package sk000801.코드트리;

import java.util.*;
import java.io.*;

//141
public class 루돌프의반란 {
    static int n, m, p;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    static int[] dx2 = {-1,0,1,0};
    static int[] dy2 = {0,1,0,-1};

    static Santa[] santas;
    static Ru ru;

    static int sanPower;
    static int ruPower;

    public static class Ru {
        int x; 
        int y;
        int dir;

        public Ru(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Santa {
        int x;
        int y;
        int dir;
        int num;
        int score;
        boolean dead;
        int sleep = -1;

        public Santa(int x, int y, int num, int score, boolean dead) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.score = score;
            this.dead = dead;
        }
    }

    public static void interact(int idx, int turnNum, int method) {
        boolean flag = false;

        Santa first = santas[idx];
        Santa cur = santas[idx];

        while(!flag) {
            flag = true;

            cur = santas[idx];

            for(int i = 0; i < p; i++) {
                if(i == idx) continue;
                if(santas[i].dead) continue;
                //|| santas[i].sleep == turnNum || santas[i].sleep+1 == turnNum

                if(cur.x == santas[i].x && cur.y == santas[i].y) {
                    flag = false;

                    if(method == 1) {
                        santas[i].x += dx[ru.dir];
                        santas[i].y += dy[ru.dir];                        
                    } else {
                        santas[i].x += dx2[first.dir];
                        santas[i].y += dy2[first.dir]; 
                    }

                    if(santas[i].x < 1 || santas[i].x > n || santas[i].y < 1 || santas[i].y > n) {
                        santas[i].dead = true;
                        return;
                    }

                    idx = i;
                    break;
                }
            }
        }        
    }

    public static void moveRu(int turnNum) {
        int minDistance = Integer.MAX_VALUE;
        Santa santa = new Santa(1,1,-1,0, true); //기본값 설정..

        // 루돌프랑 가까운 산타를 찾아가는 과정
        for(int i = 0; i < p; i++) {
            if(santas[i].dead) continue;

            Santa cur = santas[i];

            int dist = (int) Math.pow(cur.x-ru.x, 2) + (int) Math.pow(cur.y-ru.y, 2);

            if(dist < minDistance) {
                minDistance = dist;
                santa = santas[i];
            } else if(dist == minDistance && santa.num != -1) {
                if(cur.x > santa.x) {
                    santa = cur;
                } else if(cur.x == santa.x && cur.y > santa.y) {
                    santa = cur;
                }
            }
        } 

        // 산타와 가까운 방향으로 루돌프를 이동시키는 과정
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < 8; i++) {
            int nx = ru.x+dx[i];
            int ny = ru.y+dy[i];

            if(nx<1||nx>n||ny<1||ny>n) continue;
            int dist = (int) Math.pow(nx-santa.x, 2)+ (int) Math.pow(ny-santa.y, 2);
            if(dist < minDist) {
                minDist = dist;
                ru.dir = i;
            }
        }

        ru.x += dx[ru.dir];
        ru.y += dy[ru.dir];

        // 만약 그 자리에 산타가 있다면 산타를 밀쳐내는 과정
        for(int i = 0; i < p; i++) {
            if(!santas[i].dead && santas[i].x == ru.x && santas[i].y == ru.y) {
                santas[i].score += ruPower;
                santas[i].x += ruPower*dx[ru.dir];
                santas[i].y += ruPower*dy[ru.dir];

                // 멀리 나가면 상호작용 할 일이 없으니까 얼리 리턴
                if(santas[i].x < 1 || santas[i].x > n || santas[i].y < 1 || santas[i].y > n) {
                    santas[i].dead = true;
                    return;
                }

                santas[i].sleep = turnNum;

                // 아니라면 상호작용 시켜보기
                interact(i, turnNum, 1);

                return;
            }
        }
    }

    public static void moveSan(int turnNum) {
        for(int i = 0; i < p; i++) {
            // 산타가 죽었거나, 기절한 상황이면 움직이면 안됨
            if(santas[i].dead || santas[i].sleep == turnNum || santas[i].sleep+1 == turnNum) continue;

            // 현재 거리보다 루돌프와 가까운 방향을 찾음
            int minDist = (int) Math.pow(santas[i].x-ru.x, 2)+ (int) Math.pow(santas[i].y-ru.y, 2);
            int idx = -1;
            for(int j = 0; j < 4; j++) {
                int nx = santas[i].x+dx2[j];
                int ny = santas[i].y+dy2[j];

                if(nx<1||nx>n||ny<1||ny>n||isSanta(nx, ny, i)) continue;

                int dist = (int) Math.pow(nx-ru.x, 2)+ (int) Math.pow(ny-ru.y, 2);
                if(dist < minDist) {
                    minDist = dist;
                    idx = j;
                }
            }

            // 없으면 해당사항 없으므로 생략
            if(idx == -1) continue;

            // 아니라면 그 방향으로 이동
            santas[i].dir = idx;
            santas[i].x += dx2[idx];
            santas[i].y += dy2[idx];

            // 만약 이동한 자리에 루돌프가 있으면 충돌
            if(santas[i].x == ru.x && santas[i].y == ru.y) {
                santas[i].score += sanPower;
                santas[i].sleep = turnNum;
                int moveDir = idx <= 1 ? idx+2 : idx-2;
                santas[i].dir = moveDir;

                santas[i].x += sanPower*dx2[moveDir];
                santas[i].y += sanPower*dy2[moveDir];

                // 산타가 밀려나서 벗어나면 죽음
                if(santas[i].x < 1 || santas[i].x > n || santas[i].y < 1 || santas[i].y > n) {
                    santas[i].dead = true;
                    if(allDead()) return;
                    continue;
                }

                // 상호작용 체크
                interact(i, turnNum, 2);
            }
        }
    }

    public static boolean isSanta(int nx, int ny, int idx) {
        for(int i = 0; i < p; i++) {
            if(i == idx) continue;
            if(santas[i].x == nx && santas[i].y == ny) return true;
        }

        return false;
    }

    public static boolean allDead() {
        for(int i = 0; i < p; i++) {
            Santa cur = santas[i];

            if(!cur.dead) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        santas = new Santa[p];
        
        ruPower = Integer.parseInt(st.nextToken());
        sanPower = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int ruX = Integer.parseInt(st.nextToken());
        int ruY = Integer.parseInt(st.nextToken());
        ru = new Ru(ruX, ruY);

        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            int sanNum = Integer.parseInt(st.nextToken());
            int sanX = Integer.parseInt(st.nextToken());
            int sanY = Integer.parseInt(st.nextToken());
            santas[i] = new Santa(sanX, sanY, sanNum, 0, false);
        }

        Arrays.sort(santas, (a, b) -> a.num-b.num);

        for(int i = 1; i <= m; i++) {
            moveRu(i);
            moveSan(i);

            if(allDead()) break;

            for(int j = 0; j < p; j++) {
                if(!santas[j].dead) {
                    santas[j].score++;
                    //System.out.println(santas[j].num+" "+santas[j].x+" "+santas[j].y+" "+santas[j].score);
                }
            }
        }    

        int[] arr = new int[p];
        for(int i = 1; i <= p; i++) {
            for(int j = 0; j < p; j++) {
                if(santas[j].num == i) {
                    arr[i-1] = santas[j].score;
                    break;
                }
            }
        }  

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}