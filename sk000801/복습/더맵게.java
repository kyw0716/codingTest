package sk000801.복습;
import java.util.*;

//8분!! 우선순위 큐를 통해 가장 작은 값을 찾아주면 끝!!
//우선순위 큐의 크기가 1 이하일 때 아직도 pq의 최솟값이 K보다 크다면 answer을 -1로 설정
public class 더맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K && pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+2*b);
            answer++;
        }

        if(pq.peek() < K) answer = -1;
        return answer;
    }
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
}
