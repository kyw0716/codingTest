package sk000801.LEVEL2;

// 재귀와 최댓값 찾는 과정이 나한테는 어려웠던 문제..
class Solution {
    boolean[] visited;

    public int dfs(int k, int[][] dungeons) {
        int ans = 0;
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                ans = Math.max(ans, dfs(k-dungeons[i][1], dungeons));
                visited[i] = false;
            }
        }
        
        int count = 0;
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i]) count++;
        }
        
        return Math.max(count, ans);
    }
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        return dfs(k, dungeons);
    }
}
