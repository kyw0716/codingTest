import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        List<String> letter = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String ss = String.valueOf(s.charAt(i));
            if (!letter.contains(ss)) {
                letter.add(ss);
                answer[i] = -1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i-1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    answer[i] = i-j;
                    break;
                } 
            }
        }
        return answer;
    }
}