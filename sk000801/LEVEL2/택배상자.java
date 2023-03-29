package sk000801.LEVEL2;
import java.util.*;

//36분 + 풀이 참조 후 풀이 시간
//일단 정답이 1씩 추가될 수 있는 2가지 경우를 생각해야함
//애초에 숫자가 정해진 순서와 일치하는지
//아니면 stack에서 가장 윗부분의 숫자와 남은 순서의 숫자가 일치하는지
//num이 주어진 n보다 커지면 break 해야 하지만 order배열과 stack의 비교는 별개의 문제이므로
//두개의 조건 사이에 넣어야 하는 거 같다.
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        int idx = 0;
        int num = 1;
        while(true) {
            if(!stack.isEmpty() && order[idx] == stack.peek()) {
                answer++;
                stack.pop();
                idx++;
                continue;
            }
            if(num > order.length) break; //왜 얘가 항상 요 위치에 있어야 할까 
            if(order[idx] == num) {
                answer++;
                num++;
                idx++;
                continue;
            }
            stack.push(num);
            num++;
        }
        return answer;
    }
}
