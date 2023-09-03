package sk000801.백준.그래프;
import java.util.*;

//1~n까지 학생들을 모두 탐색하는데 이미 팀이 형성된 애들은 제외하고 탐색하자
//그리고 각각 방문 여부, 팀 완성 여부를 확인하는 boolean 배열이 필요함
//30분
public class 텀프로젝트 {
    static int count = 0;
    static int[] team;
    static boolean[] visited;
    static boolean[] finished;
    public static void dfs(int cur) {
        //finished가 true라면 이미 검사 완료됨
        if(finished[cur]) return;
        //방문을 했다면 이미 한 팀의 구성원임 -> check할 필요 X
        if(visited[cur]) { 
            finished[cur] = true;
            count++;
        }

        visited[cur] = true;
        dfs(team[cur]);
        //팀이 아닌 친구들도 검사했으므로 true
        finished[cur] = true;
        visited[cur] = false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            team = new int[n];
            visited = new boolean[n];
            finished = new boolean[n];
            count = 0;

            for(int j = 0; j < n; j++) {
                team[j] = in.nextInt()-1;
            }

            for(int r = 0; r < n; r++) {
                if(finished[r]) continue;
                dfs(r);
            }

            System.out.println(n-count);
        }
    }
}
