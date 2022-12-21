import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        double[] scores = new double[score.length];
        double[] sort = new double[score.length];
        String[] arr = new String[score.length];
        int[] answer = new int[score.length];
        for(int i = 0; i < score.length; i++) {
            scores[i] = (double) (score[i][0]+score[i][1])/2; //혹시나 소수점때메
            sort[i] = scores[i];
        }
        Arrays.sort(sort);
        for(int i = 0; i < sort.length; i++) {
            arr[i] = String.valueOf(sort[sort.length-i-1]);
        }
        for(int i = 0; i < sort.length; i++) {
            answer[i] = Arrays.asList(arr).indexOf(String.valueOf(scores[i]))+1;
        }
        return answer;
    }
}