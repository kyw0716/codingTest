package sk000801.백준.그래프;
import java.util.*;

//내가 생각했던 bfs 문제가 아니엿다눈...
//날짜를 배열 값에 넣어준다는 아이디어를 생각 못함..
//토마토가 익었거나 익을 것이라면 큐에 넣어줌
//결과값이 1이면 이미 다 익었으므로 0
//혹여나 배열에 0이 존재하면 -1
//결과값이 1보다 크면 -1하여 결과 출력
public class 토마토 {
    static int[] dx = {0, 0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 0, -1, 0, 1};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int m,n,h;
    static int[][][] to;
    static Queue<int[]> q = new LinkedList<>();

    public static void bfs() {

        while(!q.isEmpty()) {
            int[] jap = q.remove();

            for(int i = 0; i < 6; i++) {
                int nx = jap[0]+dx[i];
                int ny = jap[1]+dy[i];
                int nz = jap[2]+dz[i];

                if(nx<0||ny<0||nz<0||nx>=m||ny>=n||nz>=h) continue;
                if(to[nx][ny][nz] == 0) {
                    q.add(new int[]{nx, ny, nz});
                    to[nx][ny][nz] = to[jap[0]][jap[1]][jap[2]]+1;
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int r = 0; r < m; r++) {
                    if(to[r][j][i]==0) {System.out.println(-1); return;}
                    answer = Math.max(answer, to[r][j][i]);
                }
            }
        }

        if(answer == 1) {System.out.println(0); return;}
        else {System.out.println(answer-1); return;}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        h = in.nextInt();
        to = new int[m][n][h];
        
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int r = 0; r < m; r++) {
                    to[r][j][i] = in.nextInt();
                    if(to[r][j][i] == 1) q.add(new int[]{r, j, i});
                    //익은 토마토 큐에 넣어주기
                }
            }
        }

        bfs();
    }
}
