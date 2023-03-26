package sk000801.LEVEL2;
import java.util.*;

// 두 큐의 합을 미리 구해서 대소 비교를 통해 값을 옮겨야 함
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        
        int answer = 0;
        while(sum1 != sum2) {
            if(answer > queue1.length*3) return -1;
            if(sum1 > sum2) {
                int a = q1.poll();
                sum1 -= a;
                sum2 += a;
                q2.offer(a);
            } else {
                int a = q2.poll();
                sum1 += a;
                sum2 -= a;
                q1.offer(a);
            }
            answer++;
        }

        return answer;
    }
}
