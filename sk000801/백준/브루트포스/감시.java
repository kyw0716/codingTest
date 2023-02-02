package sk000801.백준.브루트포스;
import java.util.*;

//1~5 CCTV
// 1: 한쪽 벽
// 2: 반대 방향 두 칸
// 3: 수직 방향 두 칸
// 4: 세 칸
// 5: 네 칸(모든 칸)
//6 벽 -> 그 쪽 칸은 감시가 불가능
//어디가 많이 감시할 수 있는지 보는거랑 이 값을 변화시켜 주는게 참 어려울듯
//https://www.acmicpc.net/problem/15683
public class 감시 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Japyo> cctv = new ArrayList<>();

    static class Japyo {
        int x, y, num;
        Japyo(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void sang(int[][] tmp, int i, int j) {
        for(int x = i-1; x >= 0; x--) {
            if(tmp[x][j] == 6) return;
            if(tmp[x][j] != 0) continue;
            tmp[x][j] = 7;
        }
    }

    public static void ha(int[][] tmp, int i, int j) {
        for(int x = i+1; x <= n-1; x++) {
            if(tmp[x][j] == 6) break;
            if(tmp[x][j] != 0) continue;
            tmp[x][j] = 7;
        }
    }

    public static void ja(int[][] tmp, int i, int j) {
        for(int y = j-1; y >= 0; y--) {
            if(tmp[i][y] == 6) break;
            if(tmp[i][y] != 0) continue;
            tmp[i][y] = 7;
        }
    }

    public static void woo(int[][] tmp, int i, int j) {
        for(int y = j+1; y <= m-1; y++) {
            if(tmp[i][y] == 6) break;
            if(tmp[i][y] != 0) continue;
            tmp[i][y] = 7;
        }
    }

    public static int countArea(int[][] map) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static int[][] copy(int[][] map) {
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = map[i][j];
            }
        }
        return arr;
    }

    public static void dfs(int count, int[][] temp, ArrayList<Japyo> cctv) {
        if(count == cctv.size()) {
            min = Math.min(min, countArea(temp));
            return;
        }

        int num = cctv.get(count).num;
        int x = cctv.get(count).x;
        int y = cctv.get(count).y;
        int[][] tmp;

        if(num == 1) {
            tmp = copy(temp);
            ja(tmp, x, y);
            dfs(count+1, tmp, cctv);

            tmp = copy(temp);
            woo(tmp, x, y);
            dfs(count+1, tmp, cctv);

            tmp = copy(temp);
            sang(tmp, x, y);
            dfs(count+1, tmp, cctv);

            tmp = copy(temp);
            ha(tmp, x, y);
            dfs(count+1, tmp, cctv);
        } else if(num == 2) {
            tmp = copy(temp);
            sang(tmp, x, y);
            ha(tmp, x, y);
            dfs(count+1, tmp, cctv);

            tmp = copy(temp);
            ja(tmp, x, y);
            woo(tmp, x, y);
            dfs(count+1, tmp, cctv);
        } else if(num == 3) {
            tmp = copy(temp);
            ja(tmp, x, y);
            sang(tmp, x, y);
            dfs(count+1, tmp, cctv);

            tmp = copy(temp);
            sang(tmp, x, y);
            woo(tmp, x, y);
            dfs(count+1, tmp, cctv);

            tmp = copy(temp);
            woo(tmp, x, y);
            ha(tmp, x, y);
            dfs(count+1, tmp, cctv);

            tmp = copy(temp);
            ha(tmp, x, y);
            ja(tmp, x, y);
            dfs(count+1, tmp, cctv);
        } else if(num == 4) {
            tmp = copy(temp);
            ja(tmp, x, y);
            sang(tmp, x, y);
            ha(tmp, x, y);
            dfs(count+1, tmp, cctv);

            tmp = copy(temp);
            ja(tmp, x, y);
            sang(tmp, x, y);
            woo(tmp, x, y);
            dfs(count+1, tmp, cctv);

            tmp = copy(temp);
            woo(tmp, x, y);
            sang(tmp, x, y);
            ha(tmp, x, y);
            dfs(count+1, tmp, cctv);

            tmp = copy(temp);
            ja(tmp, x, y);
            ha(tmp, x, y);
            woo(tmp, x, y);
            dfs(count+1, tmp, cctv);
        } else if(num == 5) {
            tmp = copy(temp);
            ja(tmp, x, y);
            ha(tmp, x, y);
            woo(tmp, x, y);
            sang(tmp, x, y);
            dfs(count+1, tmp, cctv);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv.add(new Japyo(i, j, map[i][j]));
                }
            }
        }   

        dfs(0, map, cctv);
        System.out.println(min);
    }
}
