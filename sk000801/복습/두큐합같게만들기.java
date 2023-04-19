package sk000801.복습;
import java.util.*;

//answer가 -1이 되는 제한을 더 크게 만들어줘야 함,,
//13분!! 옛날에 풀었을 때 헤맸던 기억..
public class 두큐합같게만들기 {
    public static int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        int answer = 0;
        while(sum1 != sum2) {
            if(sum1 > sum2) {
                sum2 += q1.peek();
                q2.add(q1.peek());
                sum1 -= q1.poll();
            } else {
                sum1 += q2.peek();
                q1.add(q2.peek());
                sum2 -= q2.poll();
            }
            answer++;
            if(answer > q1.size()+q2.size()) {answer = -1; break;}
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] q1 = {3,2,7,2};
        int[] q2 = {4,6,5,1};

        System.out.println(solution(q1, q2));
    }
}
