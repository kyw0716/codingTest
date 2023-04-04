package sk000801.복습;
import java.util.*;

//10분 같지 않은 10분.. 다시 풀어봐야겠다..
//당연히 우선순위큐(내림차순)를 만들어 이 값과 주어진 배열의 인덱스가 같은지
//비교했어야 했다 그래야 가장 큰 애부터 차례대로 나갈 수 있으니까?
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }

        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
                    answer++;
                    pq.peek();
                }
                if(location == i) return answer; 
            }
        }
        return answer;
    } 
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] priorities = {2,1,3,2};
        int location = 2;
        System.out.println(s.solution(priorities, location));
    }
}
