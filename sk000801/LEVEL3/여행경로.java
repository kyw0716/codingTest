package sk000801.LEVEL3;
import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> route = new ArrayList<>();
    public void dfs(String start, String rroute, String[][] tickets, int depth) {
        if(depth == tickets.length) {
            route.add(rroute);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) { //이거 백트래킹?
            if(!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], rroute+" "+tickets[i][1], tickets, depth+1);
                visited[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        route.sort(Comparator.naturalOrder());
        //여기는 가질 수 있는 모든 경우의 수를 route에 담은 뒤에 정렬하면
        //알파벳 순으로 정렬이 되어 알파벳 순으로 가장 빠른 경로를 알려줄 것임!
        answer = route.get(0).split(" ");
        return answer;
    }
}
