import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> yaksu = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(i*i == n) yaksu.add(i);
            else if(n%i==0) {
                yaksu.add(i);
                yaksu.add(n/i);
            }
        }
        Collections.sort(yaksu);
        int[] answer = new int[yaksu.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = yaksu.get(i);
        }
        return answer;
    }
}