package sk000801.LEVEL3;
import java.util.*;
//11분, 우선순위큐를 통해 가장 큰 값부터 1씩 빼줌 
//값이 큰 수가 제곱수와의 차이가 더 벌어지기 때문에
public class 야근지수 {
    public long solution(int n, int[] works) {
        long allTime = 0;
        for(int i = 0; i < works.length; i++) {
            allTime += works[i];
        }
        if(allTime <= n) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        while(n>0) {
            int a = pq.poll();
            pq.add(a-1);
            n--;
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            answer += (long)Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}
