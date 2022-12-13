import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        List<Integer> line1 = new ArrayList<>();
        List<Integer> line2 = new ArrayList<>();
        List<Integer> line3 = new ArrayList<>();
        
        int answer = 0;
        int first = 0;
        int last = 0;
        for (int i = 0; i < lines.length; i++) {
            first = Math.min(first, lines[i][0]);
            last = Math.max(last, lines[i][1]);
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = lines[i][0]; j < lines[i][1]; j++) {
                if(i==0) line1.add(j);
                if(i==1) line2.add(j);
                if(i==2) line3.add(j);
            }
        }

        for (int i = first; i < last; i++) {
            int count = 0;
            if ((line1).contains(i)) count++;
            if ((line2).contains(i)) count++;
            if ((line3).contains(i)) count++;
            if (count >=2) answer++;
        }
        return answer;
    }
}