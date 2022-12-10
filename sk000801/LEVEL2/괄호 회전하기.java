import java.util.*;
class Solution {
    public boolean checkEmpty(String ss) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ss.length(); i++) {
            switch(ss.charAt(i)) {
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    if (stack.empty()) return false;
                    if (stack.peek() != '[') return false;
                    stack.pop();
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '}':
                    if (stack.empty()) return false;
                    if (stack.peek() != '{') return false;
                    stack.pop();
                    break;
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (stack.empty()) return false;
                    if (stack.peek() != '(') return false;
                    stack.pop();
                    break;
            }
        }
        return stack.empty();
    }
    public int solution(String s) {
        int answer = 0;
        String s1 = s;
        for (int i = 0; i < s.length(); i++) {
            if(checkEmpty(s1)) answer++;
            s1 = s1.substring(1, s.length());
            s1 += Character.toString(s.charAt(i));
        }
        return answer;
    }
}