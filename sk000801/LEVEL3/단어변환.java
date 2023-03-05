package sk000801.LEVEL3;

class Solution {
    int answer;
    boolean[] visited;
    int min  = Integer.MAX_VALUE;
    public void dfs(String begin, String target, String[] words, int count) {
        if(begin.equals(target)) {
            answer = count;
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            
            int k = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) k++;
            }
            if(k == begin.length()-1) {
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
}
