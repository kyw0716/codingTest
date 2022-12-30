import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 옥상정원꾸미기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long count = 0;

        for(int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            while(!stack.isEmpty() && stack.peek() <= height) {
                stack.pop(); 
            }
            count += stack.size(); 
            stack.push(height);
        }

        System.out.println(count);
    }
}
