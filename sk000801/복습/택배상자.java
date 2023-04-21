package sk000801.복습;
import java.util.*;

public class 택배상자 {
    //주어진 배열은 원하는 순서대로 상자를 넣는,,
    //idx를 order배열의 다음 넣을 상자 인덱스로
    //25분인데 또 봐버린,,,,
    public static int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int num = 1;
        int answer = 0;
        while(true) {
            System.out.println(num+" "+order[idx]);
            //stack 상위의 상자와 현재 넣어야 하는 상자가 같을 때
            if(!stack.isEmpty() && order[idx] == stack.peek()) {
                answer++;
                idx++;
                stack.pop();
                continue;
            }
            if(num > order.length) break;
            //아직 컨테이너 벨트에 있는 상자가 현재 넣어야 하는 상자와 같을 때
            if(order[idx] == num) {
                answer++;
                num++;
                idx++;
                continue;
            }
            //컨테이너 벨트에 있는 상자가 넣어야 하는 상자와 같지 않을 때
            stack.push(num);
            num++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] order1 = {4, 3, 1, 2, 5};
        int[] order2 = {5, 4, 3, 2, 1};
        System.out.println(solution(order1));
    }
}
