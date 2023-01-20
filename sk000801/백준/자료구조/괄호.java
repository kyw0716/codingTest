package sk000801.백준.자료구조;
import java.util.*;

public class 괄호 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        for(int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();

            String[] s = in.nextLine().split("");
            stack.push(s[0]);

            for(int j = 1; j < s.length; j++) {
                if(stack.isEmpty()) stack.push(s[j]);
                else {
                    String ss = stack.peek();
                    if(ss.equals("(") && s[j].equals(")")) stack.pop();
                    else stack.push(s[j]);
                }
            }

            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }   
}
