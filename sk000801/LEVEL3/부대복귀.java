package sk000801.LEVEL3;
import java.util.*;

//33분
//n크기 잘 못보고 신나서 플로이드 워셜 때려박다가 다익스트라로 변경..
public class 부대복귀 {
    List<List<Integer>> list = new ArrayList<>();
    int[] info;
    public void find(int dest) {
        Queue<Integer> q = new LinkedList<>();
        q.add(dest);
        info[dest] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < list.get(cur).size(); i++) {
                int val = list.get(cur).get(i);
                
                if(info[val] > info[cur]+1) {
                    info[val] = info[cur]+1;
                    q.add(val);
                }
            }

        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        info = new int[n+1];
        Arrays.fill(info, 100_001);
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++) {
            list.get(roads[i][0]).add(roads[i][1]);
            list.get(roads[i][1]).add(roads[i][0]);
        }
        
        find(destination);
        
        for(int i = 0; i < sources.length; i++) {
           answer[i] = info[sources[i]] != 100_001 ? info[sources[i]] : -1;
        }
        
        return answer;
    }
}
