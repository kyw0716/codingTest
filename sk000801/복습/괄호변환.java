package sk000801.복습;
import java.util.*;

//17분컷!!
//정말 문제에 제시된 순서를 따라가면 맞출 수 있는 문제!
public class 괄호변환 {
    public static boolean isRight(String s) {
        String[] ss = s.split("");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < ss.length; i++) {
            if(ss[i].equals("(")) stack.push(ss[i]);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        //여기서 한번 더 stack의 값을 봐야할 지 생각
        return stack.isEmpty();
    }
    public static String repeat(String p) {
        if(p.equals("")) return "";
        int count1 = 0, count2 = 0;
        String u = "", v = "";
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == ')') count1++;
            else count2++;
            if(count1 == count2) {
                u = p.substring(0, i+1);
                v = p.substring(i+1, p.length());
                break;
            }
        }
        String ans = "";
        if(isRight(u)) return u+repeat(v);
        else {
            ans += "("+repeat(v)+")";
            u = u.substring(1, u.length()-1);
            for(int i = 0; i < u.length(); i++) {
                String s = Character.toString(u.charAt(i));
                if(s.equals(")")) ans += "(";
                else ans += ")";
            }
        }
        return ans;
    }
    public static String solution(String p) {
        return repeat(p);
    }
    public static void main(String[] args) {
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";

        System.out.println(solution(p3));
    }
}
