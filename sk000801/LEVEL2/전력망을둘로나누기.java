package sk000801.LEVEL2;

import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public int graph(int n) {
        int count = 1;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(int next : list.get(node)) {
                if(!visited[next]) {
                    visited[next] = true;
                    count++;
                    q.add(next);
                } 
            }
        }
        
        return Math.abs(count-(n-count));
    }
    public int input(int idx, int[][] wires) {
        list = new ArrayList<>();
        for(int i = 0; i <= wires.length+1; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < wires.length; i++) {
            if(i == idx) continue;
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }
        return graph(wires.length+1);
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++) {
            answer = Math.min(answer, input(i, wires));
        }
        return answer;
    }
}