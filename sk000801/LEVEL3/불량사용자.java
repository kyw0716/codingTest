package sk000801.LEVEL3;
import java.util.*;
//48분
//원래는 순열을 통해 받은 ans라는 배열값을 set에 담았는데 제대로 작동을 하지 않아(그냥 다 중복 처리 해버림 ㅠㅠ)
//배열 대신 set으로 바꿔서 코드를 작성하니 정답 ㅡㅡ
class Solution {
    Set<Set<String>> set = new HashSet<>();
    int answer = 0;
    public boolean check(String[] banned_id, String[] ans) {
        for(int i = 0; i < ans.length; i++) {
             int gaesu = 0;
             if(banned_id[i].length() != ans[i].length()) return false;
             for(int j = 0; j < banned_id[i].length(); j++) {
                 if(banned_id[i].charAt(j) == '*') gaesu++;
                 if(banned_id[i].charAt(j) == ans[i].charAt(j)) gaesu++;
             }
             if(gaesu != ans[i].length()) return false;
        }
        return true;
    }
    
    public void perm(int depth, String[] user_id, String[] ans, boolean[] visited, String[] banned_id) {
        if(depth == ans.length) {
            if(check(banned_id, ans)) {
                List<String> list = Arrays.asList(ans);
               HashSet<String> set2 = new HashSet<>(list);
                set.add(set2);
            }
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = user_id[i];
                perm(depth+1, user_id, ans, visited, banned_id);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        String[] ans = new String[banned_id.length];
        boolean[] visited = new boolean[user_id.length];
        perm(0, user_id, ans, visited, banned_id);
        return set.size();
    }
}
