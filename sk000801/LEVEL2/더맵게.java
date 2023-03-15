package sk000801.LEVEL2;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        int min = pq.peek();
        
        while(min < K && pq.size()>1) {
            answer++;
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+2*b);
            min = pq.peek();
        }
        
        if(K > min) answer = -1;
        
        return answer;
    }
}
