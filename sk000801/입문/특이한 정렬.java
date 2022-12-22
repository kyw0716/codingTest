import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        List<Integer> special = new ArrayList<>();
        for(int i = 0; i< numlist.length; i++) {
            special.add(numlist[i]);
        }
        special.sort(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int aa = Math.abs(a-n);
                int bb = Math.abs(b-n);
                
                if(aa == bb) return b-a;
                else return aa-bb;
            }
        });
        for(int i = 0; i< numlist.length; i++) {
            answer[i] = special.get(i);
        }
        return answer;
    }
}

