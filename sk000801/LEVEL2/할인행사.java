package sk000801.LEVEL2;
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0; i <= discount.length-10; i++) {
            int count = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for(int j = 0; j < 10; j++) {   
                map.put(discount[j+i], map.getOrDefault(discount[j+i], 0)+1);
            }
            for(int r = 0; r < want.length; r++) {
                    if(!map.keySet().contains(want[r])) break;
                    if(map.get(want[r]) >= number[r]) count++;
            }
            if(count == want.length) answer++;
        }      
        return answer;
    }
}
