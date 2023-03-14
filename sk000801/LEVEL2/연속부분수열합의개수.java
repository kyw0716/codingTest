package sk000801.LEVEL2;

import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int[] ele = new int[elements.length*2];
        
        for(int i = 0; i < elements.length; i++) {
            ele[i] = ele[i + elements.length] = elements[i];
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(ele, j, j+i).sum());
                //이건 코테 풀면서 처음 보는.. 더 봐야겠다.
            }
        }

        return set.size();
    }
}