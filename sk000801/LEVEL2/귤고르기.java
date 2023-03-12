package sk000801.LEVEL2;
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> tan = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            tan.put(tangerine[i], tan.getOrDefault(tangerine[i], 0)+1);
        }
        
        List<Integer> gaesu = new ArrayList<>(tan.values());
        Collections.sort(gaesu, Comparator.reverseOrder());
        
        int answer = 0;
        for(int i = 0; i < gaesu.size(); i++) {
            answer++;
            k -= gaesu.get(i);
            if(k <= 0) break;
        }
        return answer;
    }
}
