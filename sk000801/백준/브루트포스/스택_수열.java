import java.util.*;

public class 스택_수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        StringBuffer answer = new StringBuffer("");

        for(int i = 0; i < n; i++) {
            int value = in.nextInt();
            
            if(value>start) {
                for(int j = start+1; j <= value; j++) {
                    stack.push(j);
                    answer.append("+");
                }
                start = value;
            } else if(stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            answer.append("-");
        } 
        
        for(int i = 0; i < answer.length(); i++) {
            System.out.println(answer.charAt(i));
        }
    }
}
