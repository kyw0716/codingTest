import java.util.*;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        Map<Integer, Integer> cloth = new HashMap<>();
        for(int i=1; i<=n; i++) {
            int value = i;
            if(Arrays.stream(reserve).anyMatch(x -> x == value)) {
                cloth.put(i, 2);
            }
            else {
                cloth.put(i,1);
            }
        }
        
        for(int i=0; i<lost.length; i++) {
            cloth.put(lost[i], cloth.get(lost[i])-1);
        }
        for(int i=0; i<lost.length; i++) {
            if(lost[i]==1 && cloth.get(1) == 0) {
                if(cloth.get(2) == 2) {
                    cloth.put(1, 1);
                    cloth.put(2, 1);
                }
            }
            else if(lost[i]>1 && lost[i] < n && cloth.get(lost[i]) == 0) {
                if(cloth.get(lost[i]-1) == 2) {
                    cloth.put(lost[i], 1);
                    cloth.put(lost[i]-1, 1);
                }
                else if(cloth.get(lost[i]+1) == 2) {
                    cloth.put(lost[i], 1);
                    cloth.put(lost[i]+1, 1);
                }
            }
            else if(lost[i]==n && cloth.get(n) == 0) {
                if(cloth.get(n-1) == 2) {
                    cloth.put(n, 1);
                    cloth.put(n-1,1);
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(cloth.get(i) >= 1) {
                answer += 1;
            }
        }
        return answer;
    }
}