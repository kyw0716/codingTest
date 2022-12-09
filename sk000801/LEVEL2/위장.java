import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        List<String> kinds = new ArrayList<>();
        HashMap<String, Integer> kind = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (!kind.keySet().contains(clothes[i][1])) {
                kind.put(clothes[i][1], 0);
                kinds.add(clothes[i][1]);
            }
            kind.put(clothes[i][1], kind.get(clothes[i][1])+1);
        }
        int answer = 1;
        for (int i = 0; i < kind.size(); i++) {
            answer *= (1+kind.get(kinds.get(i)));
        }
        return answer-1;
    }
}