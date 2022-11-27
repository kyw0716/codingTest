import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        int[] best = new int[k];
        int min = score[0];
        for(int i = 0; i < k; i++) {
            if (score[i] < min) {
                min = score[i];
            }
            if (k <= score.length) {
                    best[i] = score[i];
            } 
                answer.add(min);
        }
        if (k < score.length) {
            Arrays.sort(best);
            for(int i = k; i < score.length; i++) {
                if (score[i] > best[0]) {
                        best[0] = score[i];
                        Arrays.sort(best);
                }
                answer.add(best[0]);
            }
        } 
        int[] answerReal = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            answerReal[i] = answer.get(i);
        }
        return answerReal;
    }
}