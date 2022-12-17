import java.util.*;
class Solution {
    public String solution(String my_string) {
        String mo = "a,e,i,o,u";
        String answer = "";
        for(int i = 0; i < my_string.length(); i++) {
            String s = Character.toString(my_string.charAt(i));
            if(mo.contains(s)) answer += "";
            else answer += s;
        }
        return answer;
    }
}