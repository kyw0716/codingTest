import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> result =new ArrayList<>();
        Arrays.sort(numbers);
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                if(result.contains(numbers[i]+numbers[j])) {continue;}
                else result.add(numbers[i]+numbers[j]);
            }
        }
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}