import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] m1 = {1,2,3,4,5};
        int[] m2 = {2,1,2,3,2,4,2,5};
        int[] m3 = {3,3,1,1,2,2,4,4,5,5};
        int[] m11 = new int[answers.length];
        int[] m22 = new int[answers.length];
        int[] m33 = new int[answers.length];
        int[] count = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            m11[i] = m1[i%5];
            m22[i] = m2[i%8];
            m33[i] = m3[i%10];
            if(answers[i] == m11[i]) count[0]++;
            if(answers[i] == m22[i]) count[1]++;
            if(answers[i] == m33[i]) count[2]++;
        }
        
        int max = Math.max(Math.max(count[0], count[1]), count[2]);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max == count[0]) list.add(1);
        if(max == count[1]) list.add(2);
        if(max == count[2]) list.add(3);
        
        int[] answer = new int[list.size()];
        
        for(int i =0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}