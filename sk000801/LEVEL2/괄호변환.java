package sk000801.LEVEL2;
import java.util.*;

//정말 말그대로 주어진 설명을 따라가면 되는 문제
//근데 재귀되는 부분을 무조건 함수로 묶어줘야 함!
//52분 (수식을 엉뚱하게 써서 헤맨듯 ㅠㅠ 흑흑)
class Solution {
   public boolean isCorrect(String u) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if (c == '(') {
                s.push(c);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                s.pop();
            }
        }
        return s.isEmpty();
    }
    public String repeat(String p) {
        if(p.equals("")) return p;
        int count1 = 0; int count2 = 0;
        String u = ""; String v = "";
        String ans = "";
        for(int i = 0; i < p.length(); i++) {
            u += Character.toString(p.charAt(i));
            if(p.charAt(i) == ')') count1++;
            else count2++;
            if(count1 == count2) break;
        }
        v = p.substring(u.length(), p.length());
        if(isCorrect(u)) return u+repeat(v);
        else {
            String ss = u.substring(1, u.length()-1);
            ans += "(";
            ans += repeat(v);
            ans += ")";
            for(int i = 0; i < ss.length(); i++) {
                if(ss.charAt(i) == '(') ans += ")";
                else ans += "(";
            }
        }
        return ans;
    }
    public String solution(String p) {
        return repeat(p);
    }
}
