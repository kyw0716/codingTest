package sk000801.복습;
import java.util.*;

//12분
//우선순위 큐(내림차순)까지 접근하여 인덱스의 값과 같을때 return 하도록 했는데
//생각해보니 그냥 값만 같으면 return해주기 때문에
//while문안에 우선순위 배열을 도는 for문을 만들어 우리가 원하는 인덱스에 도달했을 때 return 해주기로 했다,,
public class 프로세스 {
    public static int solution(int[] priorities, int location) {
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(pq.peek() == priorities[i]) {
                    pq.poll();
                    idx++;

                    if(location == i) return idx;
                }
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        int[] priorities1 = {2,1,3,2}; int loc1 = 2;
        int[] priorities2 = {1,1,9,1,1,1}; int loc2 = 0;
        System.out.println(solution(priorities2, loc2));
    }
}
