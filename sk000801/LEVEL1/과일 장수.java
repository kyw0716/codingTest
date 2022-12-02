import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int index = 0;
        Arrays.sort(score);
        int[] scoreMax = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            scoreMax[i] = score[score.length-i-1];
        }
        for (int i = 1; i <= score.length/m; i++) {
            answer += scoreMax[i*m-1]*m;
        }
        return answer;
    }
}