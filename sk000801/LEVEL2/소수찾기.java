package sk000801.LEVEL2;
import java.util.*;

//이거 왜 주어진 값들은 전역 변수에 담아놓고 했는데 안됐을까
class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        dfs(numbers, new boolean[numbers.length()], 0, new StringBuilder());
        
        for (Integer num : set){
            if (num < 2) continue;
            boolean isSosu = true;
            for(int i = 2; i < num; i++){
                if (num % i == 0) {
                    isSosu = false;
                    break;
                }
            }
            if (isSosu) answer++;
        }
        
        return answer;
    }
    
    public void dfs(String numbers, boolean[] visited, int depth, StringBuilder s){                
        for(int i = 0; i < visited.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            s.append(numbers.charAt(i));
            
            set.add(Integer.parseInt(s.toString()));
            
            dfs(numbers, visited, depth+1, s);
            s.deleteCharAt(s.length()-1);
            visited[i] = false;
        }
        
    }
}
   
