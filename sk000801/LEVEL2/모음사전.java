package sk000801.LEVEL2;
import java.util.*;

//첫 글자부터 막 넣는게 아니라 모음 순서 차례대로 첫번째 글자를 지정한뒤 넣어줘야됨
class Solution {
    String[] mo = {"A","E","I","O","U"};
    public void dfs(List<String> words, String s) {
        if(s.length() > 5) return;
        if(!words.contains(s)) words.add(s);
        
        for(int i = 0; i < 5; i++) {
            dfs(words, s+mo[i]);
        }
    }
    public int solution(String word) {
        int answer = 0;
        
        List<String> words = new ArrayList<>();
        
        for(int i = 0; i < mo.length; i++) {
            dfs(words, String.valueOf(mo[i]));
        }
        
        for(int i = 0; i < words.size(); i++) {
            if(words.get(i).equals(word)) {
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}
