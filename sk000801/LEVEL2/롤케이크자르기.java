package sk000801.LEVEL2;

import java.util.*;
//역시나 시간초과가 나더라
//hashmap을 통해 중복되는 숫자들의 개수를 세주고 0이 될 때 아예 삭제토록 할 것..
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> all = new HashMap<>();
        Set<Integer> part = new HashSet<>();
        
        part.add(topping[0]);
        for(int i = 1; i < topping.length; i++) {
            all.put(topping[i], all.getOrDefault(topping[i], 0)+1);
        }

        for(int i = 1; i < topping.length; i++) {
            part.add(topping[i]);
            all.put(topping[i], all.get(topping[i])-1);
            if(all.get(topping[i]) == 0) all.remove(topping[i]);
            if(all.size() == part.size()) answer++;
        }
        return answer;
    }
}