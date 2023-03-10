package sk000801.LEVEL2;

import java.util.*;
class Solution {
    //처음에는 우선순위 배열의 인덱스도 저장해야한다고 생각했는데
    //for문을 계속 돌려서 해결해도 상관없을듯
    //들어온 순서대로니까 무조건 큐를 사용해야함 바보야ㅠㅠ
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }
        
        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    
                    if(location == i) return answer;
                }
            }
        }

        return answer;
    }
}
