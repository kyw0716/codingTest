import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
                int[] list = Arrays.copyOfRange(score, 0, i+1);
                 Arrays.sort(list);
                if (list.length > k) {
                    answer.add(list[list.length-k]);
                }  else {
                    answer.add(list[0]);
                }
        }
        int[] realAnswer = new int[answer.size()];
        for(int i = 0; i < realAnswer.length; i++) {
            realAnswer[i] = answer.get(i);
        }
        return realAnswer;
    }
}
