package sk000801.백준.구현;
import java.io.*;
import java.util.*;

//맵을 사용해줘야됨
public class 캐슬디펜스 {
    static int n, m, d;
    static int[][] castle;
    static int[] goong = new int[3]; //궁수3명의 열 저장
    static int max = 0;
    public static List<int[]> find(int x, int y, int[][] castle) {
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(castle[i][j] == 1) {
                    int dis = Math.abs(i-x)+Math.abs(j-y);
                    if(dis <= d) {
                        list.add(new int[]{i, j, dis});
                    }
                }
            }
        } //여기서 아예 해당 적이 0인경우를 생각해봐야 하나?
        if(list.size()>=2) {
            list.sort(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if(a[2] == b[2]) return a[1]-b[1];
                    return a[2]-b[2];
                }
            });
        }
        return list;
    }
    public static int process(int[] goong, int[][] castle) {
        int count = 0;
        for(int i = 0; i < 3; i++) {
            List<int[]> list = find(goong[i][0], goong[i][1], castle);
            if(list.size() >= 1) {
                int[] juk = new int[]{list.get(0)[0], list.get(0)[1]};
                if(castle[juk[0]][juk[1]] == 1) {
                    count++;
                    castle[juk[0]][juk[1]] = 0;
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(castle[i][j] == 1) {
                    castle[i][j] = 0;
                    if(i+1 <= n) castle[i+1][j] = 1;
                }
            }
        }
        return count;
    }
    public static boolean check(int[][] castle) { //적이 모두 사라졌는지 확인
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(castle[i][j] == 1) return false;
            }
        }
        return true;
    }
    public static void dfs(int start, int depth) {
        boolean[][] visited = new boolean[n+1][m+1];
        if(depth == 3) {
            int[][] map = new int[n+1][m+1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    map[i][j] = castle[i][j];
                }
            }
            int ans = 0;
            while(!check(map)) {
                ans += process(goong, map);
            }
            max = Math.max(ans, max);  
            return;
        }

        for(int i = start; i <= m; i++) {
            goong[depth] = i;
            dfs(i+1, depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        d = Integer.parseInt(s[2]);
        castle =  new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            for(int j = 1; j <= m; j++) {
                castle[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        dfs(0);

        System.out.println(max);
    }
}
