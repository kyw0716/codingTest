package sk000801.LEVEL3;
import java.util.*;

//28분
//근데 유니온파인드를 곁들인
public class 섬연결하기 {
    int[] parent;
    public int getParent(int c) {
        if(parent[c] == c) return c;
        return getParent(parent[c]);
    }
    public void union(int c1, int c2) {
        int n1 = getParent(c1);
        int n2 = getParent(c2);
        
        if(n1 < n2) parent[n2] = n1;
        else parent[n1] = n2;
    }
    public boolean find(int c1, int c2) {
        int n1 = getParent(c1);
        int n2 = getParent(c2);
        return n1 == n2;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2]-b[2];
            }
        });
        
        for(int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            if(!find(cost[0], cost[1])) {
                answer += cost[2];
                union(cost[0], cost[1]);
            }
        }

        return answer;
    }
}

//정말그리디적인생각으로만품
// class Solution {
//     List<List<Integer>> list = new ArrayList<>();
//     public boolean check(int n) {
//         boolean[] visited = new boolean[n];
//         Queue<Integer> q = new LinkedList<>();
//         q.add(0);
        
//         while(!q.isEmpty()) {
//             int cur = q.poll();
//             visited[cur] = true;
            
//             for(int i = 0; i < list.get(cur).size(); i++) {
//                 int next = list.get(cur).get(i);
//                 if(!visited[next]) {
//                     visited[next] = true;
//                     q.add(next);
//                 }
//             }
//         }
        
//         for(int i = 0; i < n; i++) {
//             if(!visited[i]) return false;
//         }
        
//         return true;
//     }
//     public int solution(int n, int[][] costs) {
//         int answer = 0;
//         Arrays.sort(costs, new Comparator<int[]>() {
//             @Override
//             public int compare(int[] a, int[] b) {
//                 return a[2]-b[2];
//             }
//         });
//         for(int i = 0; i < n; i++) {
//             list.add(new ArrayList<>());
//         }
//         for(int i = 0; i < costs.length; i++) {
//             if(check(n)) break;
//             answer += costs[i][2];
//             list.get(costs[i][0]).add(costs[i][1]);
//             list.get(costs[i][1]).add(costs[i][0]);
//         }
//         return answer;
//     }
// }
