import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        String[] numbers = my_string.replaceAll("[^0-9]","").split("");
        int[] answer = new int[numbers.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(answer);
        return answer;
    }
}