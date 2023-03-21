package sk000801.LEVEL2;
import java.util.*;

//stack 힌트 얻고 25분 10초
//처음에 저 while문을 if문으로 생각해서 풀었더니
//직전 인덱스 말고 그 이전의 인덱스들은 큰 값이 나타나도 갱신 처리가 안돼서
//while로 바꿔주었다
class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        for(int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.add(i);
        }
        return answer;
    }
}
