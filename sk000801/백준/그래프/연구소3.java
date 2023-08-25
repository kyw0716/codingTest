package sk000801.백준.그래프;
import java.util.*;

//0 빈칸, 1 벽, 2 비활성 바이러스
//https://www.acmicpc.net/problem/17142
//65분 + 시간 초과ㅠㅠ
//로직의 문제가 아니라 조합 돌릴때 시작 값 잘못 설정함,, 바보
public class 연구소3 {
    static int n;
    static int m;
    static int[][] room;
    static List<Virus> virus = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int emptySpace;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static class Virus {
        int i, j, count;
        Virus(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }

    public static void bfs(int[] idx, int empty) {
        Queue<Virus> q = new LinkedList<>();
        boolean[][] isVirus = new boolean[n][n];

        for(int i = 0; i < m; i++) {
            Virus vir = virus.get(idx[i]);
            isVirus[vir.i][vir.j] = true;
            q.add(vir);
        }

        while(!q.isEmpty()) {
                Virus cur = q.poll();

                for(int i = 0; i < 4; i++) {
                    int nx = cur.i+dx[i];
                    int ny = cur.j+dy[i];

                    if(nx<0||ny<0||nx>=n||ny>=n) continue;
                    if(isVirus[nx][ny] || room[nx][ny] == 1) continue;

                    if(room[nx][ny] == 0) empty--;
                    if(empty == 0) {
                        min = Math.min(min, cur.count+1);
                    }

                    isVirus[nx][ny] = true;
                    q.add(new Virus(nx, ny, cur.count+1));
            }
        }
    }

    public static void perm(int[] idx, boolean[] visited, int start, int depth) {
        if(depth == m) {
            bfs(idx, emptySpace);
            return;
        }

        for(int i = start; i < virus.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                idx[depth] = i;
                perm(idx, visited, i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        room = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                room[i][j] = in.nextInt();
                if(room[i][j] == 2) virus.add(new Virus(i, j, 0));
                if(room[i][j] == 0) emptySpace++;
            }
        }

        if(emptySpace == 0) {
            System.out.println(0);
            return;
        }

        int[] idx = new int[m];
        boolean[] visited = new boolean[virus.size()];
        perm(idx, visited, 0,  0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
