import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        for(int i=s1.length-1; i>=0; i--) {
            answer += s1[i];
        }
        return answer;
    }
}