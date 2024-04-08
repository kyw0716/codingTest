package sk000801.코드트리;
import java.util.*;
import java.io.*;

// 미로칸 = 0 = 빈칸 = 참가자가 이동할 수 있는
// 미로칸 = 1 ~ 9 = 벽 = 해당값 내구도 = 참가자가 이동할 수 없는 = 회전할 때 내구도가 1씩 깎임 = 0이되면, 빈 칸
// 미로칸 = 출구 = 즉시 탈출

// 참가자 1초마다 1칸씩
// 움직인 칸이 현재 칸보다 출구와 더 가까워야 함
// 그럴 수 있는 칸이 2개 이상이라면 상하로 움직이는 것을 우선시
// 한 칸에 2명 이상 있을 수 있음

// 참가자 모두가 동시에 움직인 뒤 -> 미로가 회전

public class 메이즈러너 {
    static int n,m,k;
    static int[][] map;
    static Runner[] runners;
    static int[] escape = new int[2];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Runner {
        int x; int y;
        int dist = 0;
        boolean isFinished = false;

        public Runner(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] findSquare() {
        int[][] runnerNum = new int[n+1][n+1];
        for(int i = 0; i < m; i++) {
            if(runners[i].isFinished) continue;

            runnerNum[runners[i].x][runners[i].y]++;
        }

        for(int r = 2; r < n; r++) {
            for(int i = 1; i <= n-r; i++) {
                for(int j = 1; j <= n-r; j++) {
                    boolean hasExit = false;
                    boolean hasRunner = false;

                    for(int x = i; x < i+r; x++) {
                        for(int y = j; y < j+r; y++) {
                            if(x == escape[0] && y == escape[1]) hasExit = true;
                            if(runnerNum[x][y] > 0) hasRunner = true;


                            if(hasRunner && hasExit) {
                                //System.out.println(i+" "+j+" "+r);
                                return new int[]{i, j, r};
                            }
                        }
                    }
                }
            }
        }

        return new int[]{0, 0, 0};
    }

    public static void rotateMap() {
        int[] standard = findSquare();

        int[][] newMap = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        for(int i = standard[0]; i < standard[0]+standard[2]; i++){
            for(int j = standard[1]; j < standard[1]+standard[2]; j++) {
                if(map[i][j] > 0) map[i][j]--;

                int nx = i-standard[0];
                int ny = j-standard[1];

                int rx = ny;
                int ry = standard[2]-nx-1;

                newMap[standard[0]+rx][standard[1]+ry] = map[i][j];
            }
        }

        for(int i = 0; i < m; i++) {
            if(runners[i].isFinished) continue;
            if(runners[i].x >= standard[0] && runners[i].x < standard[0]+standard[2] && runners[i].y >= standard[1] && runners[i].y < standard[1]+standard[2]) {
                int nx = runners[i].x-standard[0];
                int ny = runners[i].y-standard[1];

                int rx = ny;
                int ry = standard[2]-nx-1;

                runners[i].x = standard[0]+rx;
                runners[i].y = standard[1]+ry;
            }
        }

        if(escape[0] >= standard[0] && escape[0] < standard[0]+standard[2] && escape[1] >= standard[1] && escape[1] < standard[1]+standard[2]) {
            int nx = escape[0]-standard[0];
            int ny = escape[1]-standard[1];

            int rx = ny;
            int ry = standard[2]-nx-1;

            escape[0] = standard[0]+rx;
            escape[1] = standard[1]+ry;
        }

        map = newMap;
    }

    public static void runnerMove() {
        for(int i = 0; i < m; i++) {
            if(runners[i].isFinished) continue;

            int beforeDist = Math.abs(runners[i].x-escape[0])+Math.abs(runners[i].y-escape[1]);
            int[] newDir = new int[]{-1, -1};

            for(int j = 0; j < 4; j++) {
                int nx = runners[i].x+dx[j];
                int ny = runners[i].y+dy[j];

                if(nx<1||ny<1||nx>n||ny>n||map[nx][ny] != 0) continue;

                int newDist = Math.abs(nx-escape[0])+Math.abs(ny-escape[1]);
                if(beforeDist > newDist) {
                    beforeDist = newDist;
                    newDir[0] = nx;
                    newDir[1] = ny;
                }
            }

            if(newDir[0] != -1 && newDir[1] != -1) {
                runners[i].x = newDir[0];
                runners[i].y = newDir[1];
                runners[i].dist++;
            }

            if(runners[i].x == escape[0] && runners[i].y == escape[1]) {
                runners[i].isFinished = true;
            }
        }
    }

    public static boolean allFinished() {
        for(int i = 0; i < m; i++) {
            if(!runners[i].isFinished) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        runners = new Runner[m];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            runners[i] = new Runner(x, y);
        }

        st = new StringTokenizer(br.readLine());
        escape = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        for(int i = 1; i <= k; i++) {
            runnerMove();
            rotateMap();

            if(allFinished()) break;
        }

        int answer = 0;
        for(int i = 0; i < m; i++) {
            answer += runners[i].dist;
        }

        System.out.println(answer);
        System.out.println(escape[0]+" "+escape[1]);
    }
}