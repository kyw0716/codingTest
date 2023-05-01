package sk000801.복습;
import java.util.*;

//문제가 한 테이블에 모두를 앉히는데 상하좌우에 같은 팀원들이 앉지 않게 하는 경우의수
public class 순열 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int answer = 0;
    public static boolean check(String[][] team, String[][] ans) {
        for(int i = 0; i < ans.length; i++) {
            for(int j = 0; j < ans[i].length; j++) {
                String s = ans[i][j];
                List<String> friends = new ArrayList<>();
                for(int p = 0; p < team.length; p++) {
                    if(Arrays.asList(team[p]).contains(s)) {
                        for(int x = 0; x < team[p].length; x++) {
                            if(!team[p][x].equals(s)) friends.add(team[p][x]);
                        }
                        break;
                    }
                }
                for(int r = 0; r < 4; r++) {
                    int nx = i+dx[r];
                    int ny = j+dy[r];
                    if(nx<0||nx>=ans.length||ny<0||ny>=ans[0].length) continue;
                    if(friends.contains(ans[nx][ny])) return false;
                }
            }
        }
        return true;
    }
    public static void swap(String[] cur, int n, int r) {
        String temp = cur[n];
        cur[n] = cur[r];
        cur[r] = temp;
    }
    public static void perm(List<String> all, boolean[] visited, String[][] team, int depth, int n, int r, String[] cur) {
        if(depth == n*r) {
            int idx = 0;
            String[][] ans = new String[n][r];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < r; j++) {
                    ans[i][j] = cur[idx++];
                }
            }
            if(check(team, ans)) answer++;
            return;
        }

        for(int i = 0; i < all.size(); i++) {
            swap(cur, i, depth);
            perm(all, visited, team, depth+1, n, r, cur);
            swap(cur, i, depth);
            // if(!visited[i]) {
            //     visited[i] = true;
            //     cur[depth] = all.get(i);
            //     perm(all, visited, team, depth+1, n, r, cur);
            //     visited[i] = false;
            // }
        }
    }
    public static int solution(int n, int r, String[][] team) {
        List<String> all = new ArrayList<>();
        for(int i = 0; i < team.length; i++) {
            for(int j = 0; j < team[i].length; j++) {
                all.add(team[i][j]);
            }
        }

        String[] cur = new String[n*r];
        boolean[] visited = new boolean[n*r];
        perm(all, visited, team, 0, n, r, cur);

        return answer;
    }
    public static void main(String[] args) {
        int n1 = 2; int r1 = 3;
        String[][] team1 = {{"andy", "patrick", "jinny"},{"judy", "james"}, {"alex"}};
        System.out.println(solution(n1, r1, team1));
    }
}
