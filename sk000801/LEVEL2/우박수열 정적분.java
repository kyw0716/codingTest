import java.util.*;
class Solution {
    public double cal(int start, int fin, double[] jeokbun) {
        double answer = 0.0;
        for(int i = start; i < fin; i++) {
            answer += jeokbun[i];
        }
        return answer;
    }
    public double[] solution(int k, int[][] ranges) {
        List<Integer> result = new ArrayList<>();
        result.add(k);
        int change = k;
        while (change != 1) {
            if (change % 2 == 0) {
                change /= 2;
            } else {
                change = 3*change+1;
            }
            result.add(change);
        }
        double[] jeokbun = new double[result.size()-1];
        for (int i = 0; i < result.size()-1; i++) { //result길이 6
            jeokbun[i] = (result.get(i+1)+result.get(i))/2.0; //적분의 길이는 5 (가지고 있는 y 개수보다 1 적은)
        }
        double[] answer = new double[ranges.length]; //정답 -> 입력받은 범위 길이수
        for (int i = 0; i < ranges.length; i++) { //range길이 6 (0~5)
            if (ranges[i][0] > result.size()-1+ranges[i][1]) {
                answer[i] = -1;
            } else {
                answer[i] = cal(ranges[i][0], result.size()-1+ranges[i][1], jeokbun);
            }
        }
        return answer;
    }
}