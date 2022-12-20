// Collections.frequency()를 쓰고 싶다
// s를 split으로 분리시킨다
// 그다음에 for문을 돌려 frequency 값이 1이 나오는 친구만 문자열에 넣는다
// sort를 시켜준다
import java.util.*;
class Solution {
    public String solution(String s) {
        String[] s1 = s.split("");
        String answer = "";
        for(String ss : s1) {
            if(Collections.frequency(Arrays.asList(s1), ss)==1) answer += ss; 
        }
        String[] answer1 = answer.split("");
        Arrays.sort(answer1);
        return String.join("",answer1);
    }
}