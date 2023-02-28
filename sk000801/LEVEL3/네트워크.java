package sk000801.LEVEL3;

import java.util.*;
class Solution {
    int num;
    int[] parent;
    public int find(int x) {
        if(parent[x] == x) return x;
        
        return find(parent[x]);
    }
    public void union(int x, int y) {
        if(x==y) return;
        
        x = find(x);
        y = find(y);
        if(x>y) parent[x] = y;
        else if(x<y) parent[y] = x;
    }
    public int solution(int n, int[][] computers) {
        num = n;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< n; j++) {
                if(i==j) continue;
                if(computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        Set<Integer> parents = new HashSet<>();
        for(int i = 0; i < n; i++) {
            parents.add(find(i));
        }
       
        return parents.size();
    }
}